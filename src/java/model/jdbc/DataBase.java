package model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import model.dao.Dialeto;

public abstract class DataBase {
  protected String url = null;
  protected String usuario = null;
  protected String senha = null;
  protected String driver = null;
  protected String banco = null;
  protected String complementoDialeto = null;
  protected Connection conexao = null; 
  
  protected DataBase (String usuario, String senha, String banco) {
    this.usuario = usuario;
    this.senha = senha;
    this.banco = banco;
  }
   
  public void abrirConexao () {
    if (this.conexao == null)
      try {
        Class.forName (this.driver).newInstance ();
        this.conexao = DriverManager.getConnection (this.url, this.usuario, this.senha);
      } catch (Exception e) {
        System.out.println ("Erro: classe SqlServer - erro ao abri conexão com o banco " + this.banco + ".");
        e.printStackTrace ();
      } 
  }  

  public void fecharConexao () {
    if (this.conexao != null)
      try {
        this.conexao.close ();
        this.conexao = null;
      } catch (Exception e) {
        System.out.println ("Erro: classe DataBase - erro ao fechar conexão com o banco de dados " + this.getBanco () + ".");
        e.printStackTrace ();
      } 
  }
  
  public String getUrl () {
    return url;
  }

  public void setUrl (String url) {
    this.url = url;
  }

  public String getUsuario () {
    return usuario;
  }

  public void setUsuario (String usuario) {
    this.usuario = usuario;
  }

  public String getSenha () {
    return senha;
  }

  public void setSenha (String senha) {
    this.senha = senha;
  }
  
  public String getDriver () {
    return driver;
  }
  
  public void setDriver (String driver) {
    this.driver = driver;
  }
  
  public String getBanco () {
    return banco;
  }
  
  public void setBanco (String banco) {
    this.banco = banco;
  }

  public String getComplementoDialeto () {
    return complementoDialeto;
  }

  public void setComplementoDialeto (String complementoDialeto) {
    this.complementoDialeto = complementoDialeto;
  }
  
  public Connection getConexao () {
    return conexao;
  }

  public void setConexao (Connection conexao) {
    this.conexao = conexao;
  }  
}
