package controller.logica.estado;

import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class ExcluirEstado implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        EstadoDao dao = new EstadoDao(db);
        Estado estadoAtual = dao.encontrar(Long.parseLong(pathParts[3]));

        estadoAtual.setAtivo(0);  

        dao.remover(estadoAtual);

        request.setAttribute("estado", estadoAtual);  
    }
}  
