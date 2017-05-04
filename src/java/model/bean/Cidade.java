package model.bean;


public class Cidade {
  private long idEstado;
  private long idCidade;
  private String nome;

  

  public Cidade () {
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
public Long getIdCidade () {
    return this.idCidade;
  }

  public void setIdCidade (Long idCidade) {
    this.idCidade=idCidade;
  }
}