package controller.logica.cidade;



import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class AtualizarCidade  implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {    
    String id_str = request.getParameter ("idCidade");
    long idCidade = Long.valueOf (id_str);
    
    DataBase db = (DataBase) request.getAttribute ("db");
    Cidade cidade = (Cidade) request.getAttribute ("cidade");
    cidade.setIdCidade (idCidade);
    
    CidadeDao dao = new CidadeDao (db); //Inversão de controle e injeção de dependência.
    dao.alterar (cidade); 
    
    return "controlador?acao=usuario.ExibirUsuarios";    
  }
}  
