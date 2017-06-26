package model.dao.usuario;

import model.dao.Dialeto;

public class DialetoUsuario implements Dialeto {
    public DialetoUsuario() {
    }

    @Override
    public String inserir(){
      return "INSERT INTO dbMLS.usuario(idUsuario, login, senha, email, data, ativo) VALUES(?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String listar(){
      return "SELECT * FROM dbMLS.usuario WHERE ativo = 1 ORDER BY login";
    }

    @Override
    public String encontrar(){
      return "SELECT * FROM dbMLS.usuario WHERE idUsuario = ? AND ativo = 1";
    }

    @Override
    public String alterar(){
      return "UPDATE dbMLS.usuario SET login = ?, senha = ?, email = ?, data = ?, ativo = ? WHERE idUsuario = ?";
    }

    @Override
    public String remover(){
      return "UPDATE dbMLS.usuario SET ativo = ? WHERE idUsuario = ?";
    }
}
