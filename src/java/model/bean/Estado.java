package model.bean;


public class Estado {
  private long idEstado;
  private String nome;
  private String uf;
  

  public Estado () {
  }

  public String getNome () {
    return nome;
  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public long getIdEstado () {
    return idEstado;
  }

  public void setIdEstado (long idEstado) {
    this.idEstado = idEstado;
  }
public String getUf () {
    return this.uf;
  }

  public void setUf (String uf) {
    this.uf=uf;
  }
}