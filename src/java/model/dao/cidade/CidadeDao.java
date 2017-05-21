
package model.dao.cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Cidade;

import model.dao.Dialeto;
import model.jdbc.DataBase;

public class CidadeDao {
  protected Dialeto dialeto = null;
  Connection connection = null;

  public CidadeDao (DataBase db) {
    this.connection = db.getConexao ();
    this.dialeto = new DialetoCidade (db.getComplementoDialeto ());
  }
  
  public void inserir (Cidade c) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = dialeto.inserir ();
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, c.getNome ());
      ps.setLong (2, c.getIdEstado ());
      ps.setDate(3, c.getData());
      ps.setInt(4, c.getAtivo());
   
      
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
        Cidade c = new Cidade ();
        
        c.setIdCidade (rs.getLong ("idCidade"));
        c.setNome (rs.getString ("nome"));
        c.setIdEstado(rs.getLong("idEstado"));
        c.setData(rs.getDate("data"));
        c.setAtivo(rs.getInt("ativo"));
        resp.add (c);
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
  
  public Cidade encontrar (long id) {
    Cidade c = new Cidade ();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {      
      String sql_select = dialeto.encontrar (); 
      ps = this.connection.prepareStatement (sql_select);
      
      ps.setLong (1, id);
      
      rs = ps.executeQuery ();
      
      if (rs.next ()) {
        c.setIdCidade (rs.getLong ("idCidade"));
        c.setNome (rs.getString ("nome"));
        c.setIdEstado(rs.getLong("idEstado"));
        c.setData(rs.getDate("data"));
        c.setAtivo(rs.getInt("ativo"));
        
      }
    } catch (Exception e) {
      c = null;
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
    return c;
  }
  
  public void alterar (Cidade c) {
    PreparedStatement ps = null;
    
    try {      
      String sql_update = dialeto.alterar (); 
      ps = this.connection.prepareStatement (sql_update);
      
      ps.setString (1, c.getNome ());
      ps.setLong (2, c.getIdCidade ());
      ps.setLong (3, c.getIdEstado ());
      ps.setDate(4, c.getData());
      ps.setInt(4,c.getAtivo());
      
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
    
  public void remover  (Cidade c) {
    PreparedStatement ps = null;
    
    try {      
      String sql_delete = dialeto.remover ();
      ps = this.connection.prepareStatement (sql_delete);
      
      ps.setLong (1, c.getIdCidade ());
      
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
