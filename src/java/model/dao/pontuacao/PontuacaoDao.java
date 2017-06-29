
package model.dao.pontuacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Pontuacao;

import model.dao.Dialeto;
import model.jdbc.DataBase;

public class PontuacaoDao {
  protected Dialeto dialeto = null;
  Connection connection = null;

  public PontuacaoDao (DataBase db) {
    this.connection = db.getConexao ();
    this.dialeto = new DialetoPontuacao (db.getComplementoDialeto ());
  }
  
  public void inserir (Pontuacao p) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = dialeto.inserir ();
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString(1, p.getIdPontuacao());
      ps.setDouble(2, p.getAlimentacao());
      ps.setDouble (3, p.getInfraestrutura ());
      ps.setDouble (4, p.getLimpeza());
      ps.setDouble (5, p.getEducacao());
      ps.setDouble (6, p.getOrganizacao());
      ps.setDouble (7, p.getFlexibilidade());
      ps.setDouble (8, p.getProfissionais());
      ps.setDouble (9, p.getComunicacao());
      ps.setDouble (10, p.getCusto());
      ps.setDate(11, (java.sql.Date) p.getData());
      ps.setInt(12, p.getAtivo());
      
      ps.executeUpdate ();
    } catch (SQLException e) {
      throw new RuntimeException(e);
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
        Pontuacao p = new Pontuacao ();
        
         p.setIdPontuacao(rs.getString("idPontuacao"));
         p.setAlimentacao(rs.getLong("alimentacao"));
         p.setInfraestrutura (rs.getLong ("infraestrutura"));
         p.setLimpeza(rs.getLong("limpeza"));
         p.setLimpeza (rs.getLong("educacao"));
         p.setOrganizacao(rs.getLong("organizacao"));
         p.setFlexibilidade (rs.getLong ("flexibilidade"));
         p.setProfissionais(rs.getLong("profissionais"));
         p.setComunicacao(rs.getLong("comunicacao"));
         p.setCusto(rs.getLong("custo"));
         p.setData(rs.getDate("Data"));
         p.setAtivo(rs.getInt("Ativo"));
         
         resp.add (p);
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
  
  public Pontuacao encontrar (long id) {
    Pontuacao p = new Pontuacao ();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {      
      String sql_select = dialeto.encontrar (); 
      ps = this.connection.prepareStatement (sql_select);
      
      ps.setLong (1, id);
      
      rs = ps.executeQuery ();
      
      if (rs.next ()) {
         p.setIdPontuacao (rs.getString("idPontuacao"));
         p.setAlimentacao(rs.getLong("alimentacao"));
         p.setInfraestrutura (rs.getLong ("infraestrutura"));
         p.setLimpeza(rs.getLong("limpeza"));
         p.setLimpeza (rs.getLong("educacao"));
         p.setOrganizacao(rs.getLong("organizacao"));
         p.setFlexibilidade (rs.getLong ("flexibilidade"));
         p.setProfissionais(rs.getLong("profissionais"));
         p.setComunicacao(rs.getLong("comunicacao"));
         p.setCusto(rs.getLong("custo"));
         p.setData(rs.getDate("Data"));
         p.setAtivo(rs.getInt("Ativo"));
      }
    } catch (Exception e) {
      p = null;
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
    return p;
  }
  
  public void alterar (Pontuacao p) {
    PreparedStatement ps = null;
    
    try {      
      String sql_update = dialeto.alterar (); 
      ps = this.connection.prepareStatement (sql_update);
      
      ps.setDouble (1, p.getAlimentacao ());
      ps.setDouble (2, p.getInfraestrutura ());
      ps.setDouble (3, p.getLimpeza());
      ps.setDouble (4, p.getEducacao());
      ps.setDouble (5, p.getOrganizacao());
      ps.setDouble (6, p.getFlexibilidade());
      ps.setDouble (7, p.getProfissionais());
      ps.setDouble (8, p.getComunicacao());
      ps.setDouble (9, p.getCusto());
      ps.setString (10,p.getIdPontuacao());
      ps.setDate   (11,p.getData());
      ps.setInt    (12,p.getAtivo());
      
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
    
  public void remover  (Pontuacao p) {
    PreparedStatement ps = null;
    
    try {      
      String sql_delete = dialeto.remover ();
      ps = this.connection.prepareStatement (sql_delete);
      
      ps.setString(1, p.getIdPontuacao ());
      
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
