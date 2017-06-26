package model.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Pessoa;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class PessoaDao{
    private final String exceptionError;
    protected Dialeto dialeto = null;
    Connection connection = null;

    public PessoaDao(DataBase db){
        this.exceptionError = "Erro: classe EstadoDao - não foi possível fechar o manipulador de BD!";
        this.connection = db.getConexao();
        this.dialeto = new DialetoPessoa();
    }

    public void inserir(Pessoa p){
        PreparedStatement ps = null;

        try{      
            String sql_insert = dialeto.inserir();
            ps = this.connection.prepareStatement(sql_insert);
                        
            ps.setLong(1, p.getIdPessoa());
            ps.setLong(2, p.getIdUsuario());
            ps.setString(3, p.getCpf());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getSenha());
            ps.setString(6, p.getNome());
            ps.setLong(7, p.getIdEndereco());
            ps.setDate(8, (java.sql.Date) p.getData());
            ps.setInt(9, p.getAtivo());

            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(ps != null)
                    ps.close();
            }catch(SQLException e){
                System.out.println(exceptionError);
            }
        }  
    }

    public List listar () {
        List resp = new LinkedList ();
        Statement stmt = null;
        ResultSet rs = null;

        try {      
            stmt = this.connection.createStatement ();
            String sql_select = dialeto.listar ();
            rs = stmt.executeQuery (sql_select);

            while (rs.next()) {
                Pessoa  p   = new Pessoa ();

                p.setIdPessoa(rs.getLong("idPessoa"));
                p.setIdUsuario(rs.getLong("idUsuario"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("senha"));
                p.setIdEndereco (rs.getLong("idEndereco"));
                p.setNome (rs.getString ("nome"));
                p.setData((java.sql.Date) rs.getDate("data"));
                p.setAtivo(rs.getInt("ativo"));
                
                resp.add (p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) 
                    rs.close ();      
                if (stmt != null)
                    stmt.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  

        return resp;
    }

    public Pessoa encontrar (long id) {
        Pessoa p = new Pessoa ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {      
            String sql_select = dialeto.encontrar (); 
            ps = this.connection.prepareStatement (sql_select);

            ps.setLong (1, id);

            rs = ps.executeQuery ();

            if (rs.next()) {
                p.setIdPessoa(rs.getLong("idPessoa"));
                p.setIdUsuario(rs.getLong("idUsuario"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("senha"));
                p.setIdEndereco (rs.getLong("idEndereco"));
                p.setNome (rs.getString ("nome"));
                p.setData((java.sql.Date) rs.getDate("data"));
                p.setAtivo(rs.getInt("ativo"));
            }
        } catch (SQLException e) {
          throw new RuntimeException(e);
        } finally {
          try {
            if (rs != null) 
                rs.close ();      
            if (ps != null)
                ps.close ();
          } catch (SQLException e) {
            System.out.println (exceptionError);
          }
        }  
        
        return p;
    }

    public void alterar (Pessoa p) {
        PreparedStatement ps = null;

        try {      
            String sql_update = dialeto.alterar (); 
            ps = this.connection.prepareStatement (sql_update);

            ps.setLong(1, p.getIdUsuario());
            ps.setString(1, p.getCpf());
            ps.setString(2, p.getEmail());
            ps.setString(3,p.getSenha());
            ps.setString(4,p.getNome());
            ps.setLong(5, p.getIdEndereco());
            ps.setDate(6, (java.sql.Date) p.getData());
            ps.setInt(7, p.getAtivo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null)
                    ps.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  
    }

    public void remover(Pessoa p) {
        PreparedStatement ps = null;

        try {      
            String sql_delete = dialeto.remover ();
            ps = this.connection.prepareStatement (sql_delete);

            ps.setInt(1, p.getAtivo());
            ps.setLong(2, p.getIdPessoa());

            ps.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
              if (ps != null)
                ps.close ();
            } catch (SQLException e) {
                System.out.println (exceptionError);
            }
        }  
    }

    public Dialeto getDialeto () {
        return dialeto;
    }

    public void setDialeto (Dialeto dialeto) {
        this.dialeto = dialeto;
    } 
}
