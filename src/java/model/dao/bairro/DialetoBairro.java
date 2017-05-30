package model.dao.bairro;


import model.dao.Dialeto;

public class DialetoBairro implements Dialeto {
    String complemento = "";

    public DialetoBairro () {
    }

    @Override
    public String inserir () {
      return "insert into dbMLS.bairro (nome,idCidade,data, ativo) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String listar () {
      return "select * from dbMLS.bairro WHERE ativo = 1";
    }

    @Override
    public String encontrar () {
      return "select * from dbMLS.bairro WHERE idBairro = ? AND ativo = 1";
    }

    @Override
    public String alterar () {
      return "update dbMLS.bairro SET nome = ?,idCidade = ? , data = ?, ativo = ? where idBairro = ?";
    }

    @Override
    public String remover () {
      return "update dbMLS.bairro SET ativo = 0 WHERE idBairro = ?";   
    }
    
    public String encontrarEscolaBairro(){
      return "SELECT * FROM dbMLS.escola es JOIN dbMLS.endereco en ON es.idEndereco = en.idEndereco WHERE en.idBairro = ?";
    }    
}
