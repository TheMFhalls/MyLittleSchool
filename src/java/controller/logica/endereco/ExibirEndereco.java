package controller.logica.endereco;

import controller.logica.bairro.*;
import controller.logica.cidade.*;
import controller.logica.estado.*;
import controller.logica.usuario.*;
import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;

import model.jdbc.DataBase;

public class ExibirEndereco implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    DataBase db = (DataBase) request.getAttribute ("db");
    
    EnderecoDao dao = new EnderecoDao (db); //Inversão de controle e injeção de dependência.
    List<Endereco> enderecos = dao.listar ();
    
    request.setAttribute ("bairros",enderecos);
 // verificar esse return   
   return "WEB-INF/view/listarUsuarios.jsp";    
  }  
}
