package model.dao.pontuacao;



import model.dao.Dialeto;

public class DialetoPontuacao implements Dialeto {
  String complemento = "";

  public DialetoPontuacao (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "INSERT INTO dbMLS.pontuacao(idPontuacao, alimentacao, infraestrutura, limpeza, educacao, organizacao, flexibilidade, "
            + "profissionais, comunicacao, custo, data, ativo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  }

  @Override
  public String listar () {
    return "SELECT * FROM dbMLS.pontuacao WHERE ativo = 1";
  }

  @Override
  public String encontrar () {
    return "select * from db.MLS.pontuacao where idPontuacao = ? AND ativo = 1";
  }

  @Override
  public String alterar () {
    return "update db.MLS.pontuacao set alimentacao = ?,infraestrutura = ?, limpeza = ?,"
            + "educacao = ?, organizacao = ?, flexibilidade = ?, profissionais =?, comunicacao = ?, custo = ?"
            + "where idPontuacao = ?, data = ?, ativo = ? WHERE idPontuacao = ?";
  }

  @Override
  public String remover () {
    return "update from db.MLS.pontuacao SET ativo = 0 where idPontuacao = ?";
  }
}
