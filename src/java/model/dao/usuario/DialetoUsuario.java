package model.dao.usuario;

import model.dao.Dialeto;
import model.dao.Dialeto;

public class DialetoUsuario implements Dialeto {
  String complemento = "";

  public DialetoUsuario (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into mls" + this.complemento + ".usuario (nome, email, senha, data_nascimento) values (?, ?, ?, ?)";
  }

  @Override
  public String listar () {
    return "select * from mls" + this.complemento + ".usuario";
  }

  @Override
  public String encontrar () {
    return "select * from mls" + this.complemento + ".usuario where id = ?";
  }

  @Override
  public String alterar () {
    return "update mls" + this.complemento + ".usuario set nome = ?, email = ?, senha = ?, data_nascimento = ? where id = ?";
  }

  @Override
  public String remover () {
    return "delete from mls" + this.complemento + ".usuario where id = ?";
  }
}
