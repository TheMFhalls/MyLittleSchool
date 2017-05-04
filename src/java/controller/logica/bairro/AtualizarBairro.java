package controller.logica.bairro;




import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.bairro.BairroDao;

import model.jdbc.DataBase;

public class AtualizarBairro  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {    
    String id_str = request.getParameter ("idBairro");
    long idBairro = Long.valueOf (id_str);
    
    DataBase db = (DataBase) request.getAttribute ("db");
    Bairro bairro = (Bairro) request.getAttribute ("bairro");
    bairro.setIdBairro (idBairro);
    
    BairroDao dao = new BairroDao (db); //Inversão de controle e injeção de dependência.
    dao.alterar (bairro); 
   //rever esse return 
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
