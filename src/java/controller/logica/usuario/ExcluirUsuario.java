package controller.logica.usuario;

import controller.logica.Logica;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
import model.jdbc.DataBase;

public class ExcluirUsuario  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    String id_str = request.getParameter ("id");
    long id = Long.valueOf (id_str);
    
    DataBase db = (DataBase) request.getAttribute ("db");
    
    UsuarioDao dao = new UsuarioDao (db); //Inversão de controle e injeção de dependência.
    Usuario usuario = dao.encontrar (id);
    dao.remover (usuario); 
    
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
