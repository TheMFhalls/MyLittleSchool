package controller.logica.bairro;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.bairro.BairroDao;
import model.jdbc.DataBase;

public class EncontrarEscolaBairro implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {        
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        BairroDao dao = new BairroDao(db); //Inversão de controle e injeção de dependência.
        List<Escola> escola = dao.encontrarEscolaBairro(Long.parseLong(pathParts[3]));

        request.setAttribute("escolas", escola); 
    }  
}
