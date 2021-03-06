
package model.dao.bairro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.bean.Bairro;
import model.bean.Escola;
import model.dao.Dialeto;
import model.jdbc.DataBase;

public class BairroDao {
  protected Dialeto dialeto = null;
  Connection connection = null;

  public BairroDao (DataBase db) {
    this.connection = db.getConexao ();
    this.dialeto = new DialetoBairro ();
  }
  
  public void inserir (Bairro b) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = dialeto.inserir ();
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, b.getNome ());
      ps.setLong (2, b.getIdCidade ());
      ps.setDate(3, b.getData());
      ps.setInt(4, b.getAtivo());
   
      
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
        Bairro b = new Bairro ();
        
        b.setIdBairro (rs.getLong ("idBairro"));
        b.setNome (rs.getString ("nome"));
        b.setIdCidade(rs.getLong("idcidade"));
        b.setData(rs.getDate("data"));
        b.setAtivo(rs.getInt("ativo"));
        resp.add (b);
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
  
  public Bairro encontrar (long id) {
    Bairro b = new Bairro ();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {      
      String sql_select = dialeto.encontrar (); 
      ps = this.connection.prepareStatement (sql_select);
      
      ps.setLong (1, id);
      
      rs = ps.executeQuery ();
      
      if (rs.next ()) {
        b.setIdBairro (rs.getLong ("idBairro"));
        b.setNome (rs.getString ("nome"));
        b.setIdCidade(rs.getLong("idCidade"));
        b.setData(rs.getDate("data"));
        b.setAtivo(rs.getInt("ativo"));
        
      }
    } catch (Exception e) {
      b = null;
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
    return b;
  }
  
  public void alterar (Bairro b) {
    PreparedStatement ps = null;
    
    try {      
      String sql_update = dialeto.alterar (); 
      ps = this.connection.prepareStatement (sql_update);
      
      ps.setString (1, b.getNome ());
      ps.setLong (2, b.getIdBairro ());
      ps.setLong (3, b.getIdCidade ());
      ps.setDate(4, b.getData());
      ps.setInt(5, b.getAtivo());
      
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
    
  public void remover  (Bairro b) {
    PreparedStatement ps = null;
    
    try {      
      String sql_delete = dialeto.remover ();
      ps = this.connection.prepareStatement (sql_delete);
      
      ps.setLong (1, b.getIdBairro ());
      
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
  
  public List encontrarEscolaBairro(long id){
        DialetoBairro dialetoEspecifico = new DialetoBairro();
        List resp = new LinkedList ();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {         
            String sql_select = dialetoEspecifico.encontrarEscolaBairro();

            ps = this.connection.prepareStatement (sql_select);
            ps.setLong(1, id);
            rs = ps.executeQuery ();

            while (rs.next()) {
                Escola e = new Escola();

                e.setIdEscola (rs.getString ("idEscola"));
                e.setCnpj (rs.getString ("cnpj"));
                e.setNomeFantasia (rs.getString ("nomeFantasia"));
                e.setRazaoSocial (rs.getString ("razaoSocial"));
                e.setIdPontuacao (rs.getString ("idPontuacao"));
                e.setIdEndereco (rs.getString ("idEndereco"));
                e.setSenha (rs.getString ("senha"));
                e.setData((java.sql.Date) rs.getDate("data"));
                e.setAtivo(rs.getInt("ativo"));

                resp.add(e);
            }
        } catch (SQLException e) {
            resp = null;
            System.out.println ("Erro: classe EstadoDao - não foi possível ler os dados dos Estados a partir do BD!");
        } finally {
            try {
                if (rs != null) 
                    rs.close ();      
                if (ps != null)
                    ps.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage());
            }
        }  

        return resp;
    }

  public Dialeto getDialeto () {
    return dialeto;
  }

  public void setDialeto (Dialeto dialeto) {
    this.dialeto = dialeto;
  }
}
