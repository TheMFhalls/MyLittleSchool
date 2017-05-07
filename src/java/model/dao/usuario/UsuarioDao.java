package model.dao.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Usuario;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class UsuarioDao {
  protected Dialeto dialeto = null;
  Connection connection = null;

  public UsuarioDao (DataBase db) {
    this.connection = db.getConexao ();
    this.dialeto = new DialetoUsuario (db.getComplementoDialeto ());
  }
  
  public void inserir (Usuario u) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = dialeto.inserir ();
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, u.getNome ());
      ps.setString (2, u.getEmail ());
      ps.setString (3, u.getSenha ());
      ps.setDate (4, Date.valueOf (u.getData_nascimento ()));
      
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro: classe UsuarioDao - não foi possível inserir o usuário no BD.");
      e.printStackTrace ();
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível fechar o manipulador de BD!");
        e.printStackTrace ();
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
        Usuario u = new Usuario ();
        
        u.setId (rs.getLong ("id"));
        u.setNome (rs.getString ("nome"));
        u.setEmail (rs.getString ("email"));
        u.setSenha (rs.getString ("senha"));
        u.setData_nascimento (rs.getDate ("data_nascimento").toLocalDate ());
                  
        resp.add (u);
      }
    } catch (Exception e) {
      resp = null;
      System.out.println ("Erro: classe UsuarioDao - não foi possível ler os dados dos usuário a partir do BD!");
      e.printStackTrace ();
    } finally {
      try {
        if (rs != null) 
          rs.close ();      
        if (stmt != null)
          stmt.close ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível fechar os manipuladores do BD!");
        e.printStackTrace ();
      }
    }  
    
    return resp;
  }
  
  public Usuario encontrar (long id) {
    Usuario u = new Usuario ();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {      
      String sql_select = dialeto.encontrar (); 
      ps = this.connection.prepareStatement (sql_select);
      
      ps.setLong (1, id);
      
      rs = ps.executeQuery ();
      
      if (rs.next ()) {
        u.setId (rs.getLong ("id"));
        u.setNome (rs.getString ("nome"));
        u.setEmail (rs.getString ("email"));
        u.setSenha (rs.getString ("senha"));
        u.setData_nascimento (rs.getDate ("data_nascimento").toLocalDate ());
      }
    } catch (Exception e) {
      u = null;
      System.out.println ("Erro: classe UsuarioDao - usuário não encontrado.");
      e.printStackTrace ();
    } finally {
      try {
        if (rs != null) 
          rs.close ();      
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível fechar o manipulador de BD!");
        e.printStackTrace ();
      }
    }  
    return u;
  }
  
  public void alterar (Usuario u) {
    PreparedStatement ps = null;
    
    try {      
      String sql_update = dialeto.alterar (); 
      ps = this.connection.prepareStatement (sql_update);
      
      ps.setString (1, u.getNome ());
      ps.setString (2, u.getEmail ());
      ps.setString (3, u.getSenha ());
      ps.setDate (4, Date.valueOf (u.getData_nascimento ()));
      ps.setLong (5, u.getId ());
      
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro: classe UsuarioDao - não foi possível atualizar o usuário no BD.");
      e.printStackTrace ();
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível fechar o manipulador de BD!");
        e.printStackTrace ();
      }
    }  
  }
    
  public void remover  (Usuario u) {
    PreparedStatement ps = null;
    
    try {      
      String sql_delete = dialeto.remover ();
      ps = this.connection.prepareStatement (sql_delete);
      
      ps.setLong (1, u.getId ());
      
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro: classe UsuarioDao - não foi possível excluir o usuário no BD.");
      e.printStackTrace ();
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro: classe UsuarioDao - não foi possível fechar o manipulador de BD!");
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
