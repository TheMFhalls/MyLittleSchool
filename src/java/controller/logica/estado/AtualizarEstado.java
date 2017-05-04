package controller.logica.estado;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class AtualizarEstado  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {    
    String id_str = request.getParameter ("idEstado");
    long idEstado = Long.valueOf (id_str);
    
    DataBase db = (DataBase) request.getAttribute ("db");
    Estado estado = (Estado) request.getAttribute ("estado");
    estado.setIdEstado (idEstado);
    
    EstadoDao dao = new EstadoDao (db); //Inversão de controle e injeção de dependência.
    dao.alterar (estado); 
    
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
