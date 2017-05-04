package model.bean;


public class Bairro {
  private long idBairro;
  private long idCidade;
  private String nome;

  

  public Bairro () {
  }

  public String getNome () {
    return nome;
  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public long getIdBairro () {
    return idBairro;
  }

  public void setIdBairro (long idBairro) {
    this.idBairro = idBairro;
  }
public Long getIdCidade () {
    return this.idCidade;
  }

  public void setIdCidade (Long idCidade) {
    this.idCidade=idCidade;
  }
}