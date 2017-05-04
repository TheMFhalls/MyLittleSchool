package controller.logica.usuario;

import controller.logica.Logica;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
import model.jdbc.DataBase;

public class ExibirUsuarios implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    DataBase db = (DataBase) request.getAttribute ("db");
    
    UsuarioDao dao = new UsuarioDao (db); //Inversão de controle e injeção de dependência.
    List<Usuario> usuarios = dao.listar ();
    
    request.setAttribute ("usuarios", usuarios);
    
    return "WEB-INF/view/listarUsuarios.jsp";    
  }  
}
