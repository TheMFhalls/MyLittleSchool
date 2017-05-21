package model.dao.cidade;


import model.dao.estado.*;
import model.dao.Dialeto;
import model.dao.Dialeto;

public class DialetoCidade implements Dialeto {
  String complemento = "";

  public DialetoCidade (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into db.MLS.cidade (nome,idEstado,data,ativo) values (?, ?, ? , ?)";
  }

  @Override
  public String listar () {
    return "select * from db.MLS.cidade WHERE ativo = 1";
  }

  @Override
  public String encontrar () {
    return "select * from db.MLS.cidade where idCidade = ? AND ativo = 1";
  }

  @Override
  public String alterar () {
    return "update db.MLS.cidade set nome = ?,idEstado = ?, ativo = ? where idCidade = ?";
  }

  @Override
  public String remover () {
    return "update from db.MLS.cidade SET ativo = 0 where idCidade = ?";
  }
}
