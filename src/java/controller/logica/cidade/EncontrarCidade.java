package controller.logica.cidade;


import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class EncontrarCidade implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        CidadeDao dao = new CidadeDao(db); //Inversão de controle e injeção de dependência.
        Cidade cidade = dao.encontrar(Long.parseLong(pathParts[3]));

        request.setAttribute("cidade", cidade);   
    }  
}
