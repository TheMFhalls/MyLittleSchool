package model.dao.cidade;

import model.dao.Dialeto;

public class DialetoCidade implements Dialeto {
  String complemento = "";

  public DialetoCidade () {
  }
  
  @Override
  public String inserir () {
    return "insert into dbMLS.cidade (nome,idEstado,data,ativo) values (?, ?, ? , ?)";
  }

  @Override
  public String listar () {
    return "select * from dbMLS.cidade WHERE ativo = 1";
  }

  @Override
  public String encontrar () {
    return "select * from dbMLS.cidade where idCidade = ? AND ativo = 1";
  }

  @Override
  public String alterar () {
    return "update dbMLS.cidade set nome = ?,idEstado = ?, ativo = ? where idCidade = ?";
  }

  @Override
  public String remover () {
    return "update from dbMLS.cidade SET ativo = 0 where idCidade = ?";
  } 
  
  public String encontrarBairroCidade(){
    return "select * from dbMLS.bairro where idCidade = ? AND ativo = 1";
  }
}
