package controller.logica.endereco;


import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;
import model.jdbc.DataBase;

public class EncontrarEndereco implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        EnderecoDao dao = new EnderecoDao(db); //Inversão de controle e injeção de dependência.
        Endereco endereco = dao.encontrar(Long.parseLong(pathParts[2]));

        request.setAttribute("endereco", endereco);   
    }  
}
