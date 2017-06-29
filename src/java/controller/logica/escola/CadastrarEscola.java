package controller.logica.escola;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class CadastrarEscola implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        Long idEscola = dataAtual.getTime();
        
        Gson gson = new Gson();
        Escola escola = gson.fromJson(data, Escola.class);
        
        escola.setIdEscola(String.valueOf(idEscola));
        escola.setData(dataAtual);
        escola.setAtivo(1);

        EscolaDao dao = new EscolaDao(db); 
        
        dao.inserir(escola);

        request.setAttribute("escola", escola); 
    }
}  
