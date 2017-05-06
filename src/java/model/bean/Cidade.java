package model.bean;

import java.sql.Date;

public class Cidade {
    private long    idCidade;
    private String  nome;
    private long    idEstado;
    private Date    data;
    private int     ativo;

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
    
    public long getIdCidade () {
      return this.idCidade;
    }

    public void setIdCidade (long idCidade) {
      this.idCidade = idCidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }   
}