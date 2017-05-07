package model.bean;

import java.sql.Date;

public class PessoaPessoa {
    private long idPessoaPessoa;
    private long idPessoa1;
    private long idPessoa2;
    private long idMensagem;
    private Date data;
    private int ativo;
    
    public PessoaPessoa(){
    }

    public long getIdPessoaPessoa() {
        return idPessoaPessoa;
    }

    public void setIdPessoaPessoa(long idPessoaPessoa) {
        this.idPessoaPessoa = idPessoaPessoa;
    }

    public long getIdPessoa1() {
        return idPessoa1;
    }

    public void setIdPessoa1(long idPessoa1) {
        this.idPessoa1 = idPessoa1;
    }

    public long getIdPessoa2() {
        return idPessoa2;
    }

    public void setIdPessoa2(long idPessoa2) {
        this.idPessoa2 = idPessoa2;
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
