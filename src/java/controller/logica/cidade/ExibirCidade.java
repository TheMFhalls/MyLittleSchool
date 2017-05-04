package controller.logica.cidade;

import controller.logica.estado.*;
import controller.logica.usuario.*;
import controller.logica.Logica;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class ExibirCidade implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    DataBase db = (DataBase) request.getAttribute ("db");
    
    CidadeDao dao = new CidadeDao (db); //Inversão de controle e injeção de dependência.
    List<Cidade> cidades = dao.listar ();
    
    request.setAttribute ("cidades",cidades);
 // verificar esse return   
   return "WEB-INF/view/listarUsuarios.jsp";    
  }  
}
