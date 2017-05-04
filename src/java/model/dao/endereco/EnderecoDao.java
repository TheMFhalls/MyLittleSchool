
package model.dao.endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Endereco;

import model.dao.Dialeto;
import model.jdbc.DataBase;

public class EnderecoDao {
  protected Dialeto dialeto = null;
  Connection connection = null;

  public EnderecoDao (DataBase db) {
    this.connection = db.getConexao ();
    this.dialeto = new DialetoEndereco (db.getComplementoDialeto ());
  }
  
  public void inserir (Endereco en) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = dialeto.inserir ();
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setLong (1, en.getIdEndereco ());
      ps.setString (2, en.getLogradouro ());
      ps.setLong (3,en.getNumero());
      ps.setLong (4, en.getIdBairro());
      ps.setString (5, en.getComplemento());
      
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
        Endereco en = new Endereco ();
        
        en.setIdEndereco (rs.getLong ("idEndereco"));
        en.setLogradouro (rs.getString ("logradouro"));
        en.setNumero (rs.getLong("numero"));
        en.setIdBairro(rs.getLong("idBairro"));
        en.setComplemento(rs.getString ("complemento"));
        resp.add (en);
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
  
  public Endereco encontrar (long id) {
    Endereco en = new Endereco ();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {      
      String sql_select = dialeto.encontrar (); 
      ps = this.connection.prepareStatement (sql_select);
      
      ps.setLong (1, id);
      
      rs = ps.executeQuery ();
      
      if (rs.next ()) {
        en.setIdEndereco (rs.getLong ("idEndereco"));
        en.setLogradouro (rs.getString ("logradouro"));
        en.setNumero (rs.getLong ("numero"));
        en.setComplemento(rs.getString("complemento"));
        en.setIdBairro(rs.getLong("idBairro"));
        
      }
    } catch (Exception e) {
      en = null;
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
    return en;
  }
  
  public void alterar (Endereco en) {
    PreparedStatement ps = null;
    
    try {      
      String sql_update = dialeto.alterar (); 
      ps = this.connection.prepareStatement (sql_update);
      
      ps.setLong (1,en.getIdEndereco());
      ps.setString (2, en.getLogradouro ());
      ps.setLong (3, en.getNumero ());
      ps.setLong (4, en.getIdBairro ());
      ps.setString (5, en.getComplemento());
      
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
    
  public void remover  (Endereco en) {
    PreparedStatement ps = null;
    
    try {      
      String sql_delete = dialeto.remover ();
      ps = this.connection.prepareStatement (sql_delete);
      
      ps.setLong (1, en.getIdEndereco ());
      
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
