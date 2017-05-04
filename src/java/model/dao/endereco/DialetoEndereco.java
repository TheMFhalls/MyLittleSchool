package model.dao.endereco;


import model.dao.cidade.*;
import model.dao.estado.*;
import model.dao.Dialeto;
import model.dao.Dialeto;

public class DialetoEndereco implements Dialeto {
  String complemento = "";

  public DialetoEndereco (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into mls" + this.complemento + ".endereco (logradouro,numero,idBairro,complemento) "
            + "values (?, ?,?,?,)";
  }

  @Override
  public String listar () {
    return "select * from mls" + this.complemento + ".endereco";
  }

  @Override
  public String encontrar () {
    return "select * from mls" + this.complemento + ".endereco where idEndereco = ?";
  }

  @Override
  public String alterar () {
    return "update mls" + this.complemento + ".endereco set logradouro = ?,idBairro = ?,numero = ?, logradouro = ? "
            + "where idEndereco = ?";
  }

  @Override
  public String remover () {
    return "delete from mls" + this.complemento + ".endereco where idEndereco = ?";
  }
}
