package controller.logica.estado;


import controller.logica.Logica;
import functions.Functions;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class AtualizarEstado implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        Functions funcao = new Functions();
        String[] data = funcao.splitData(
                request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))
        );
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        EstadoDao dao = new EstadoDao(db);
        Estado estado = dao.encontrar(Long.parseLong(pathParts[3]));
        
        estado.setIdEstado(Long.parseLong(pathParts[3]));
        //estado.setNome(request.getParameter("nome"));  

        request.setAttribute("estado", estado);  

    }
}  
