package controller.logica.pessoa;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pessoa;
import model.dao.pessoa.PessoaDao;
import model.jdbc.DataBase;

public class ExcluirPessoa implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        PessoaDao dao = new PessoaDao(db);
        Pessoa pessoaAtual = dao.encontrar(Long.parseLong(pathParts[3]));

        pessoaAtual.setAtivo(0);  

        dao.remover(pessoaAtual);

        request.setAttribute("pessoa", pessoaAtual);  
    }
}  
