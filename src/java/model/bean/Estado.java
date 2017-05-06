package model.bean;

import java.sql.Date;

public class Estado {
    private long    idEstado;
    private String  nome;
    private String  uf;
    private Date    data;
    private int     ativo;
    
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
      this.uf = uf;
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