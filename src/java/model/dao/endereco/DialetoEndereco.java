package model.dao.endereco;


import model.dao.Dialeto;

public class DialetoEndereco implements Dialeto {
  String complemento = "";

  public DialetoEndereco (String complemento) {
    this.complemento = complemento;
  }
  
  @Override
  public String inserir () {
    return "insert into db.MLS.endereco (logradouro,numero,idBairro,complemento, data, ativo) "
            + "values (?, ?,?,?,?,?)";
  }

  @Override
  public String listar () {
    return "select * from db.MLS.endereco where ativo = 1";
  }

  @Override
  public String encontrar () {
    return "select * from db.MLS.endereco where idEndereco = ? AND ativo = 1";
  }

  @Override
  public String alterar () {
    return "update db.MLS.endereco SET logradouro = ?,idBairro = ?,numero = ?, logradouro = ? "
            + "data = ?, ativo = ? where idEndereco = ?";
  }

  @Override
  public String remover () {
    return "update from db.MLS.endereco SET ativo = 0 where idEndereco = ?";
  }
}
