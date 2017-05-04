package controller.logica.usuario;

import controller.logica.Logica;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
import model.jdbc.DataBase;

public class CadastrarUsuario  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    DataBase db = (DataBase) request.getAttribute ("db");
    Usuario usuario = (Usuario) request.getAttribute ("usuario");
    
    UsuarioDao dao = new UsuarioDao (db); //Inversão de controle e injeção de dependência.
    dao.inserir (usuario); //Inversão de controle e injeção de dependência.
    
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
