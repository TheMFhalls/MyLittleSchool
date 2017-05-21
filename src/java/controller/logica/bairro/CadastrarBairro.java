package controller.logica.bairro;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Bairro;
import model.dao.bairro.BairroDao;
import model.jdbc.DataBase;

public class CadastrarBairro implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Bairro bairro = gson.fromJson(data, Bairro.class);
        
        bairro.setData(dataAtual);
        bairro.setAtivo(1);

        BairroDao dao = new BairroDao(db); 
        
        dao.inserir(bairro);

        request.setAttribute("bairro", bairro); 
    }
}  
