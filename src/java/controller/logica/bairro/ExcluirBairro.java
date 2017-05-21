package controller.logica.bairro;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.bairro.BairroDao;
import model.jdbc.DataBase;

public class ExcluirBairro implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        BairroDao dao = new BairroDao(db);
        Bairro bairroAtual = dao.encontrar(Long.parseLong(pathParts[3]));

        bairroAtual.setAtivo(0);  

        dao.remover(bairroAtual);

        request.setAttribute("bairro", bairroAtual);  
    }
}  
