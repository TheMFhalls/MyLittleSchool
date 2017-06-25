package controller.logica.estado;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class EncontrarCidadeEstado implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {        
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        EstadoDao dao = new EstadoDao(db); //Inversão de controle e injeção de dependência.
        List<Cidade> cidades = dao.encontrarCidadeEstado(Long.parseLong(pathParts[2]));

        request.setAttribute("cidades", cidades);  
    }  
}
