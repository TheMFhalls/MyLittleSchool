package model.dao.estado;

import model.bean.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class EstadoDao{
    private String exceptionError;
    protected Dialeto dialeto = null;
    Connection connection = null;

    public EstadoDao(DataBase db){
        this.exceptionError = "Erro: classe EstadoDao - não foi possível fechar o manipulador de BD!";
        this.connection = db.getConexao();
        this.dialeto = new DialetoEstado();
    }

    public void inserir(Estado es){
        PreparedStatement ps = null;

        try{      
            String sql_insert = dialeto.inserir();
            ps = this.connection.prepareStatement(sql_insert);

            ps.setString(1, es.getNome());
            ps.setString(2, es.getUf());
            ps.setDate(3, es.getData());
            ps.setInt(4, es.getAtivo());

            ps.executeUpdate ();
        }catch(Exception e){
            System.out.println("Erro: classe EstadoDao - não foi possível inserir o Estado no BD.");
            e.printStackTrace();
        }finally{
            try{
                if(ps != null)
                    ps.close();
            }catch(Exception e){
                System.out.println(exceptionError);
                e.printStackTrace();
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
                Estado es = new Estado ();

                es.setIdEstado (rs.getLong ("id"));
                es.setNome (rs.getString ("nome"));
                es.setUf(rs.getString("uf"));
                es.setData(rs.getDate("data"));
                es.setAtivo(rs.getInt("ativo"));
                
                resp.add (es);
            }
        } catch (Exception e) {
            resp = null;
            System.out.println ("Erro: classe EstadoDao - não foi possível ler os dados dos Estados a partir do BD!");
            e.printStackTrace ();
        } finally {
            try {
                if (rs != null) 
                    rs.close ();      
                if (stmt != null)
                    stmt.close ();
            } catch (Exception e) {
                System.out.println (exceptionError);
                e.printStackTrace ();
            }
        }  

        return resp;
    }

    public Estado encontrar (long id) {
        Estado es = new Estado ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {      
            String sql_select = dialeto.encontrar (); 
            ps = this.connection.prepareStatement (sql_select);

            ps.setLong (1, id);

            rs = ps.executeQuery ();

            if (rs.next()) {
                es.setIdEstado (rs.getLong ("id"));
                es.setNome (rs.getString ("nome"));
                es.setUf(rs.getString("uf"));
                es.setData(rs.getDate("data"));
                es.setAtivo(rs.getInt("ativo"));
            }
        } catch (Exception e) {
          es = null;
          System.out.println ("Erro: classe EstadoDao - Estado não encontrado.");
          e.printStackTrace ();
        } finally {
          try {
            if (rs != null) 
                rs.close ();      
            if (ps != null)
                ps.close ();
          } catch (Exception e) {
            System.out.println (exceptionError);
            e.printStackTrace ();
          }
        }  
        
        return es;
    }

    public void alterar (Estado es) {
        PreparedStatement ps = null;

        try {      
            String sql_update = dialeto.alterar (); 
            ps = this.connection.prepareStatement (sql_update);

            ps.setString(1, es.getNome());
            ps.setString(2, es.getUf());
            ps.setDate(3, es.getData());
            ps.setInt(3, es.getAtivo());

            ps.executeUpdate ();
        } catch (Exception e) {
            System.out.println ("Erro: classe EstadoDao - não foi possível atualizar o Estado no BD.");
            e.printStackTrace ();
        } finally {
            try {
                if (ps != null)
                    ps.close ();
            } catch (Exception e) {
                System.out.println (exceptionError);
                e.printStackTrace ();
            }
        }  
    }

    public void remover(Estado es) {
      PreparedStatement ps = null;

      try {      
        String sql_delete = dialeto.remover ();
        ps = this.connection.prepareStatement (sql_delete);

        ps.setLong (1, es.getIdEstado ());

        ps.executeUpdate ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível excluir o usuário no BD.");
        e.printStackTrace ();
      } finally {
        try {
          if (ps != null)
            ps.close ();
        } catch (Exception e) {
          System.out.println (exceptionError);
          e.printStackTrace ();
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
