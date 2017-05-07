package model.dao.bairro;

import model.dao.cidade.*;
import model.dao.estado.*;
import model.dao.Dialeto;

public class DialetoBairro implements Dialeto {
    String complemento = "";

    public DialetoBairro (String complemento) {
      this.complemento = complemento;
    }

    @Override
    public String inserir () {
      return "insert into mls" + this.complemento + ".bairro (nome,idCidade) values (?, ?)";
    }

    @Override
    public String listar () {
      return "select * from mls" + this.complemento + ".bairro";
    }

    @Override
    public String encontrar () {
      return "select * from mls" + this.complemento + ".bairro where idBairro = ?";
    }

    @Override
    public String alterar () {
      return "update mls" + this.complemento + ".bairro set nome = ?,idCidade = ? where idBairro = ?";
    }

    @Override
    public String remover () {
      return "delete from mls" + this.complemento + ".bairro where idBairro = ?";
    }
}
