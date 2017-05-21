package controller.logica.cidade;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Cidade;
import model.dao.cidade.CidadeDao;
import model.jdbc.DataBase;

public class AtualizarCidade implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Cidade cidadeNova = gson.fromJson(data, Cidade.class);

        CidadeDao dao = new CidadeDao(db);
        Cidade cidadeAtual = dao.encontrar(Long.parseLong(pathParts[3]));
        
        cidadeAtual.setIdCidade(Long.parseLong(pathParts[3]));
        cidadeAtual.setNome(cidadeNova.getNome());  
        cidadeAtual.setIdEstado(cidadeNova.getIdEstado());  
        cidadeAtual.setData(dataAtual);
        cidadeAtual.setAtivo(1);  
        
        dao.alterar(cidadeAtual);

        request.setAttribute("cidade", cidadeAtual); 
    }
}  
