package controller.logica.endereco;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;
import model.jdbc.DataBase;

public class ExcluirEndereco implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        EnderecoDao dao = new EnderecoDao(db);
        Endereco enderecoAtual = dao.encontrar(Long.parseLong(pathParts[3]));

        enderecoAtual.setAtivo(0);  

        dao.remover(enderecoAtual);

        request.setAttribute("endereco", enderecoAtual);  
    }
}  
