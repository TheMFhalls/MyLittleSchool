package controller.logica.bairro;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.bairro.BairroDao;
import model.jdbc.DataBase;

public class AtualizarBairro implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Bairro bairroNovo = gson.fromJson(data, Bairro.class);

        BairroDao dao = new BairroDao(db);
        Bairro bairroAtual = dao.encontrar(Long.parseLong(pathParts[3]));
        
        bairroAtual.setIdBairro(bairroNovo.getIdBairro());
        bairroAtual.setIdCidade(bairroNovo.getIdCidade());
        bairroAtual.setNome(bairroNovo.getNome());
        bairroAtual.setData(dataAtual);
        bairroAtual.setAtivo(1);  
        
        dao.alterar(bairroAtual);

        request.setAttribute("bairro", bairroAtual); 
    }
}  
