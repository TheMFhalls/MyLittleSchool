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
    
    public String encontrarPessoaUsuario(){
        return "SELECT u.login , u.email , p.cpf , p.nome , e.logradouro , b.nome as bairro , "
        +"c.nome as cidade , est.nome as estado FROM usuario u INNER JOIN pessoa p ON u.idUsuario "
        +"= p.idUsuario INNER JOIN endereco e ON p.idEndereco = e.idEndereco INNER JOIN bairro b ON "
        +"e.idBairro = b.idBairro INNER JOIN cidade c ON b.idCidade = c.idCidade INNER JOIN estado est "
        +"ON c.idEstado = est.idEstado WHERE u.ativo = 1 AND p.ativo = 1 AND e.ativo = 1 AND b.ativo = 1 "
        +"AND c.ativo = 1 AND est.ativo = 1 AND u.idUsuario = ?";
    }
}
