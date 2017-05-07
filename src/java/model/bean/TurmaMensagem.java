package model.bean;

import java.sql.Date;

public class TurmaMensagem {
    private long idTurmaMensagem;
    private long idTurma;
    private long idMensagem;
    private Date data;
    private int ativo;
    
    public TurmaMensagem(){
    }

    public long getIdTurmaMensagem() {
        return idTurmaMensagem;
    }

    public void setIdTurmaMensagem(long idTurmaMensagem) {
        this.idTurmaMensagem = idTurmaMensagem;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(long idMensagem) {
        this.idMensagem = idMensagem;
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
