package controller.logica.bairro;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.bairro.BairroDao;
import model.jdbc.DataBase;

public class ExibirBairro implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");

        BairroDao dao = new BairroDao(db); //Inversão de controle e injeção de dependência.
        List<Bairro> bairros = dao.listar();

        request.setAttribute("bairros", bairros);   
    }  
}
