package model.dao.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Usuario;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class UsuarioDao{
    private final String exceptionError;
    protected Dialeto dialeto = null;
    Connection connection = null;

    public UsuarioDao(DataBase db){
        this.exceptionError = "Erro: classe EstadoDao - não foi possível fechar o manipulador de BD!";
        this.connection = db.getConexao();
        this.dialeto = new DialetoUsuario();
    }

    public void inserir(Usuario user){
        PreparedStatement ps = null;

        try{      
            String sql_insert = dialeto.inserir();
            ps = this.connection.prepareStatement(sql_insert);
            
            ps.setLong(1, user.getIdUsuario());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getEmail());
            ps.setDate(5, (java.sql.Date) user.getData());
            ps.setInt(6, user.getAtivo());

            ps.executeUpdate ();
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
                Usuario user = new Usuario();
                
                user.setIdUsuario (rs.getLong("idUsuario"));
                user.setLogin (rs.getString("login"));
                user.setSenha (rs.getString ("senha"));
                user.setEmail (rs.getString("email"));
                user.setData ((java.sql.Date) rs.getDate("data"));
                user.setAtivo (rs.getInt("ativo"));
                
                resp.add (user);
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

    public Usuario encontrar (long id) {
        Usuario user = new Usuario ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {      
            String sql_select = dialeto.encontrar (); 
            ps = this.connection.prepareStatement (sql_select);

            ps.setLong (1, id);

            rs = ps.executeQuery ();

            if (rs.next()) {
                user.setIdUsuario (rs.getLong ("idUsuario"));
                user.setLogin (rs.getString ("login"));
                user.setSenha (rs.getString("senha"));
                user.setEmail (rs.getString("email"));
                user.setData((java.sql.Date) rs.getDate("data"));
                user.setAtivo(rs.getInt("ativo"));
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
        
        return user;
    }

    public void alterar (Usuario user) {
        PreparedStatement ps = null;

        try {      
            String sql_update = dialeto.alterar (); 
            ps = this.connection.prepareStatement (sql_update);

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getEmail());
            ps.setDate(4, (java.sql.Date) user.getData());
            ps.setInt(5, user.getAtivo());

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

    public void remover(Usuario user) {
        PreparedStatement ps = null;

        try {      
            String sql_delete = dialeto.remover ();
            ps = this.connection.prepareStatement (sql_delete);

            ps.setInt(1, user.getAtivo());
            ps.setLong(2, user.getIdUsuario());

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
