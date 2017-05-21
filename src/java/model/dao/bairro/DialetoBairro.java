package model.dao.bairro;


import model.dao.Dialeto;

public class DialetoBairro implements Dialeto {
    String complemento = "";

    public DialetoBairro (String complemento) {
      this.complemento = complemento;
    }

    @Override
    public String inserir () {
      return "insert into db.MLS.bairro (nome,idCidade,data, ativo) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String listar () {
      return "select * from db.MLS.bairro WHERE ativo = 1";
    }

    @Override
    public String encontrar () {
      return "select * from db.MLS.bairro WHERE idBairro = ? AND ativo = 1";
    }

    @Override
    public String alterar () {
      return "update db.MLS.bairro SET nome = ?,idCidade = ? , data = ?, ativo = ? where idBairro = ?";
    }

    @Override
    public String remover () {
      return "update db.MLS.bairro SET ativo = 0 WHERE idBairro = ?";   
    }
}
