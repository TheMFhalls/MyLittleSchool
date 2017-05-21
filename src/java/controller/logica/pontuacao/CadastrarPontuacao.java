package controller.logica.pontuacao;


;
import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pontuacao;
import model.dao.pontuacao.PontuacaoDao;
import model.jdbc.DataBase;

public class CadastrarPontuacao implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Pontuacao pontuacao = gson.fromJson(data, Pontuacao.class);
        
        pontuacao.setData(dataAtual);
        pontuacao.setAtivo(1);

        PontuacaoDao dao = new PontuacaoDao(db); 
        
        dao.inserir(pontuacao);

        request.setAttribute("pontuacao", pontuacao); 
    }
}  
