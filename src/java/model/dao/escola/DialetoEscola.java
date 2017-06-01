package model.dao.escola;

import model.dao.Dialeto;

public class DialetoEscola implements Dialeto {
    public DialetoEscola() {
    }

    @Override
    public String inserir(){
      return "INSERT INTO dbMLS.escola(cnpj, nomeFantasia, razaoSocial, idPontuacao, idEndereco,data, ativo) VALUES(?, ?, ?, ?,?,?,?)";
    }

    @Override
    public String listar(){
      return "SELECT * FROM dbMLS.escola WHERE ativo = 1";
    }

    @Override
    public String encontrar(){
      return "SELECT * FROM dbMLS.escola WHERE idEscola = ? AND ativo = 1";
    }

    @Override
    public String alterar(){
      return "UPDATE dbMLS.estado SET cnpj = ?, nomeFantasia = ?, razaoSocial = ?, idPontuacao = ?, idEndereco, data = ?, ativo = ? WHERE idEscola = ?";
    }

    @Override
    public String remover(){
      return "UPDATE dbMLS.estado SET ativo = ? WHERE idEscola = ?";
    }
    
    public String encontrarEnderecoEscola(){
      return "SELECT en.logradouro logradouro , en.numero numero , en.complemento complemento FROM endereco en "
      +"JOIN escola es ON en.idEndereco = es.idEndereco WHERE es.idEscola = ? AND es.ativo = 1 AND en.ativo = 1";
    }
}
