package model.bean;

import java.sql.Date;

public class Bairro {
    private long      idBairro;
    private String    nome;
    private long      idCidade;
    private Date      data;
    private int       ativo;



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

    public long getIdCidade () {
      return this.idCidade;
    }

    public void setIdCidade (long idCidade) {
      this.idCidade=idCidade;
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