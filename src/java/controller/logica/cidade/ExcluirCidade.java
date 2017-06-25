package controller.logica.cidade;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class ExcluirCidade implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        CidadeDao dao = new CidadeDao(db);
        Cidade cidadeAtual = dao.encontrar(Long.parseLong(pathParts[2]));

        cidadeAtual.setAtivo(0);  

        dao.remover(cidadeAtual);

        request.setAttribute("cidade", cidadeAtual);  
    }
}  
