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
    return "insert into mls" + this.complemento + ".cidade (nome,idEstado) values (?, ?)";
  }

  @Override
  public String listar () {
    return "select * from mls" + this.complemento + ".cidade";
  }

  @Override
  public String encontrar () {
    return "select * from mls" + this.complemento + ".cidade where idCidade = ?";
  }

  @Override
  public String alterar () {
    return "update mls" + this.complemento + ".cidade set nome = ?,idEstado = ? where idCidade = ?";
  }

  @Override
  public String remover () {
    return "delete from mls" + this.complemento + ".cidade where idCidade = ?";
  }
}
