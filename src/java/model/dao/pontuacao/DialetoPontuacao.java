package model.dao.pontuacao;


import model.dao.estado.*;
import model.dao.Dialeto;
import model.dao.Dialeto;

public class DialetoPontuacao implements Dialeto {
  String complemento = "";

  public DialetoPontuacao (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into mls" + this.complemento + ".pontuacao (alimentacao,infraestrutura,limpeza,"
            + "educacao,organizacao,flexibilidade,profissionais,comunicacao, custo) "
            + "values (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public String listar () {
    return "select * from mls" + this.complemento + ".pontucao";
  }

  @Override
  public String encontrar () {
    return "select * from mls" + this.complemento + ".pontuacao where idPontuacao = ?";
  }

  @Override
  public String alterar () {
    return "update mls" + this.complemento + ".pontuacao set alimentacao = ?,infraestrutura = ?, limpeza = ?,"
            + "educacao = ?, organizacao = ?, flexibilidade = ?, profissionais =?, comunicacao = ?, custo = ?"
            + "where idPontuacao = ?";
  }

  @Override
  public String remover () {
    return "delete from mls" + this.complemento + ".pontuacao where idPontuacao = ?";
  }
}
