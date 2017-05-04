package model.dao.estado;


import model.dao.Dialeto;
import model.dao.Dialeto;

public class DialetoEstado implements Dialeto {
  String complemento = "";

  public DialetoEstado (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into mls" + this.complemento + ".estado (nome,uf) values (?, ?)";
  }

  @Override
  public String listar () {
    return "select * from mls" + this.complemento + ".estado";
  }

  @Override
  public String encontrar () {
    return "select * from mls" + this.complemento + ".estado where idEstado = ?";
  }

  @Override
  public String alterar () {
    return "update mls" + this.complemento + ".estado set nome = ?,uf = ? where idEstado = ?";
  }

  @Override
  public String remover () {
    return "delete from mls" + this.complemento + ".estado where idEstado = ?";
  }
}
