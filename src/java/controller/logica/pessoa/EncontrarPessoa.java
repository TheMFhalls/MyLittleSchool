package controller.logica.pessoa;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pessoa;
import model.dao.pessoa.PessoaDao;
import model.jdbc.DataBase;

public class EncontrarPessoa implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        PessoaDao dao = new PessoaDao(db); //Inversão de controle e injeção de dependência.
        Pessoa pessoa = dao.encontrar(Long.parseLong(pathParts[3]));

        request.setAttribute("pesssoa", pessoa);   
    }  
}
