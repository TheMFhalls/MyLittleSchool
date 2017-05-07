package controller.logica.estado;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class ExibirEstado implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");

        EstadoDao dao = new EstadoDao(db); //Inversão de controle e injeção de dependência.
        List<Estado> estados = dao.listar();

        request.setAttribute("estados", estados);   
    }  
}
