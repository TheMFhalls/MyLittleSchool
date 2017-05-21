package controller.logica.escola;


import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class ExibirEscola implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");

        EscolaDao dao = new EscolaDao(db); //Inversão de controle e injeção de dependência.
        List<Escola> escolas = dao.listar();

        request.setAttribute("escolas", escolas);   
    }  
}
