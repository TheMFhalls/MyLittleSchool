package model.bean;

import java.sql.Date;

public class Endereco {
    private long    idEndereco;
    private int     numero;
    private String  nome;
    private String  logradouro;
    private String  complemento;
    private long    idBairro;
    private Date    data;
    private int     ativo;
  
    public Endereco () {
    }
    
    public long getIdEndereco() {
        return idEndereco;
    }
    
    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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