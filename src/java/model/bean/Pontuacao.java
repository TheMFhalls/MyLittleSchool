package model.bean;


public class Pontuacao {
  
    
  private long idPontuacao;
  private long alimentacao;
  private long infraestrutura;
  private long limpeza;
  private long educacao;
  private long organizacao;
  private long flexibilidade;
  private long profissionais;
  private long comunicacao;
  private long custo;
   
 
  
   public Pontuacao () {
  }

   
    public long getIdPontuacao() {
        return idPontuacao;
    }

    public void setIdPontuacao(long idPontuacao) {
        this.idPontuacao = idPontuacao;
    }

   
    public long getAlimentacao() {
        return alimentacao;
    }

   
    public void setAlimentacao(long alimentacao) {
        this.alimentacao = alimentacao;
    }

    public long getInfraestrutura() {
        return infraestrutura;
    }

    public void setInfraestrutura(long infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

   
    public long getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(long limpeza) {
        this.limpeza = limpeza;
    }

    public long getEducacao() {
        return educacao;
    }

    public void setEducacao(long educacao) {
        this.educacao = educacao;
    }

    public long getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(long organizacao) {
        this.organizacao = organizacao;
    }

    public long getFlexibilidade() {
        return flexibilidade;
    }

    public void setFlexibilidade(long flexibilidade) {
        this.flexibilidade = flexibilidade;
    }

    public long getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(long profissionais) {
        this.profissionais = profissionais;
    }

    public long getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(long comunicacao) {
        this.comunicacao = comunicacao;
    }

    public long getCusto() {
        return custo;
    }

    public void setCusto(long custo) {
        this.custo = custo;
    }
 
 
}