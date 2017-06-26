package model.dao.pessoa;


import model.dao.Dialeto;

public class DialetoPessoa implements Dialeto {
    public DialetoPessoa() {
    }

    @Override
    public String inserir(){
      return "INSERT INTO dbMLS.pessoa(idPessoa, idUsuario, cpf, email, senha, nome, idEndereco, data, ativo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String listar(){
      return "SELECT * FROM dbMLS.pessoa WHERE ativo = 1";
    }

    @Override
    public String encontrar(){
      return "SELECT * FROM dbMLS.pessoa WHERE idPessoa = ? AND ativo = 1";
    }

    @Override
    public String alterar(){
      return "UPDATE dbMLS.pessoa SET idUsuario = ?, cpf = ?, email = ?, senha = ?, nome = ?, idEndereco = ?, data = ?, ativo = ? WHERE idPessoa = ?";
    }

    @Override
    public String remover(){
      return "UPDATE dbMLS.pessoa SET ativo = 0 WHERE idPessoa = ?";
    }
}
