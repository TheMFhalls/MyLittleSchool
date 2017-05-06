package model.bean;

import java.sql.Date;

public class Turma{
    private long    idTurma;
    private String  nome;
    private long    idEscola;
    private Date    data;
    private int     ativo;
    
    public Turma(){
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(long idEscola) {
        this.idEscola = idEscola;
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