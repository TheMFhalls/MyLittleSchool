package model.bean;


public class Endereco {
private long idEndereco;
  private long numero;
  private long idBairro;
  private String nome;
  private String logradouro;
  private String complemento;
  
  
  
  public Endereco () {
  }

  
    public long getIdEndereco() {
        return idEndereco;
    }


    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
  

  

 
}