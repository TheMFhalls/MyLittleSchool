package controller.logica.escola;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class EncontrarEscola implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        EscolaDao dao = new EscolaDao(db); //Inversão de controle e injeção de dependência.
        Escola escola = dao.encontrar(Long.parseLong(pathParts[2]));

        request.setAttribute("escola", escola);   
    }  
}
