package controller.logica.escola;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class ExcluirEscola implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        EscolaDao dao = new EscolaDao(db);
        Escola escolaAtual = dao.encontrar(Long.parseLong(pathParts[3]));

        escolaAtual.setAtivo(0);  

        dao.remover(escolaAtual);

        request.setAttribute("escola", escolaAtual);  
    }
}  
