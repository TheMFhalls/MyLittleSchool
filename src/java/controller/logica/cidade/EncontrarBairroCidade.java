package controller.logica.cidade;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class EncontrarBairroCidade implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {        
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        CidadeDao dao = new CidadeDao(db); //Inversão de controle e injeção de dependência.
        List<Bairro> bairro = dao.encontrarBairroCidade(Long.parseLong(pathParts[2]));

        request.setAttribute("bairros", bairro); 
    }  
}
