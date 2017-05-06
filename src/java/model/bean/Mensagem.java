package model.bean;

import java.sql.Date;

public class Mensagem {
    private long    idMensagem;
    private String  mensgem;
    private Date    data;
    private int     ativo;
    
    public Mensagem(){
    }

    public long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getMensgem() {
        return mensgem;
    }

    public void setMensgem(String mensgem) {
        this.mensgem = mensgem;
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
