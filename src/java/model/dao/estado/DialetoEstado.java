package model.dao.estado;

import model.dao.Dialeto;

public class DialetoEstado implements Dialeto {
    public DialetoEstado() {
    }

    @Override
    public String inserir(){
      return "INSERT INTO dbMLS.estado(nome, uf, data, ativo) VALUES(?, ?, ?, ?)";
    }

    @Override
    public String listar(){
      return "SELECT * FROM dbMLS.estado WHERE ativo = 1 ORDER BY nome";
    }

    @Override
    public String encontrar(){
      return "SELECT * FROM dbMLS.estado WHERE idEstado = ? AND ativo = 1 ORDER BY nome";
    }

    @Override
    public String alterar(){
      return "UPDATE dbMLS.estado SET nome = ?, uf = ?, data = ?, ativo = ? WHERE idEstado = ?";
    }

    @Override
    public String remover(){
      return "UPDATE dbMLS.estado SET ativo = ? WHERE idEstado = ?";
    }
}
