package model.bean;

import java.sql.Date;

public class Pontuacao {   

   
    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    private long    idPontuacao;
    private double  alimentacao;
    private double  infraestrutura;
    private double  limpeza;
    private double  educacao;
    private double  organizacao;
    private double  flexibilidade;
    private double  profissionais;
    private double  comunicacao;
    private double  custo; 
    private Date    data;
    private int     ativo;
  
    public Pontuacao () {
    }

    public long getIdPontuacao() {
        return idPontuacao;
    }

    public void setIdPontuacao(long idPontuacao) {
        this.idPontuacao = idPontuacao;
    }

    public double getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(double alimentacao) {
        this.alimentacao = alimentacao;
    }

    public double getInfraestrutura() {
        return infraestrutura;
    }

    public void setInfraestrutura(double infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

    public double getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(double limpeza) {
        this.limpeza = limpeza;
    }

    public double getEducacao() {
        return educacao;
    }

    public void setEducacao(double educacao) {
        this.educacao = educacao;
    }

    public double getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(double organizacao) {
        this.organizacao = organizacao;
    }

    public double getFlexibilidade() {
        return flexibilidade;
    }

    public void setFlexibilidade(double flexibilidade) {
        this.flexibilidade = flexibilidade;
    }

    public double getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(double profissionais) {
        this.profissionais = profissionais;
    }

    public double getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(double comunicacao) {
        this.comunicacao = comunicacao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
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

}// fim class