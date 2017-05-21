package controller.logica.pessoa;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pessoa;
import model.dao.pessoa.PessoaDao;
import model.jdbc.DataBase;

public class ExibirPessoa implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");

        PessoaDao dao = new PessoaDao(db); //Inversão de controle e injeção de dependência.
        List<Pessoa> pessoas = dao.listar();

        request.setAttribute("pessoas", pessoas);   
    }  
}
