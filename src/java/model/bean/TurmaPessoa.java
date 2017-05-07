package model.bean;

import java.sql.Date;

public class TurmaPessoa {
    private long    idTurmaPessoa;
    private int     quantidade;
    private long    idPessoa;
    private long    idTurma;
    private Date    data;
    private int     ativo;
    
    public TurmaPessoa(){
    }

    public long getIdTurmaPessoa() {
        return idTurmaPessoa;
    }

    public void setIdTurmaPessoa(long idTurmaPessoa) {
        this.idTurmaPessoa = idTurmaPessoa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
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
