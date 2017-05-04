package controller.logica.endereco;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;

import model.jdbc.DataBase;

public class AtualizarEndereco  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {    
    String id_str = request.getParameter ("idEndereco");
    long idEndereco = Long.valueOf (id_str);
    
    DataBase db = (DataBase) request.getAttribute ("db");
    Endereco endereco = (Endereco) request.getAttribute ("endereco");
    endereco.setIdEndereco (idEndereco);
    
    EnderecoDao dao = new EnderecoDao (db); //Inversão de controle e injeção de dependência.
    dao.alterar (endereco); 
   //rever esse return 
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
