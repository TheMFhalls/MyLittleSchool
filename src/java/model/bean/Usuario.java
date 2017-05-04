package model.bean;

import java.time.LocalDate;

public class Usuario {
  private long id;
  private String nome;
  private String email;
  private String senha;
  private String[] generos; 
  private LocalDate data_nascimento;

  public Usuario () {
  }

  public String getNome () {
    return nome;
  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public String getSenha () {
    return senha;
  }

  public void setSenha (String senha) {
    this.senha = senha;
  }

  public String[] getGeneros () {
    return generos;
  }

  public void setGeneros (String[] generos) {
    this.generos = generos;
  }

  public LocalDate getData_nascimento () {
    return data_nascimento;
  }

  public void setData_nascimento (LocalDate data_nascimento) {
    this.data_nascimento = data_nascimento;
  }

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }
}
