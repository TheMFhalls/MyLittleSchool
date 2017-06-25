package controller.logica.pontuacao;


import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pontuacao;
import model.dao.pontuacao.PontuacaoDao;
import model.jdbc.DataBase;

public class AtualizarPontuacao implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Pontuacao pontuacaoNova = gson.fromJson(data, Pontuacao.class);

        PontuacaoDao dao = new PontuacaoDao(db);
        Pontuacao pontuacaoAtual = dao.encontrar(Long.parseLong(pathParts[2]));
        
        pontuacaoAtual.setIdPontuacao(Long.parseLong(pathParts[2]));
        pontuacaoAtual.setAlimentacao(pontuacaoNova.getAlimentacao());   
        pontuacaoAtual.setComunicacao(pontuacaoNova.getComunicacao());
        pontuacaoAtual.setCusto(pontuacaoNova.getCusto());
        pontuacaoAtual.setEducacao(pontuacaoNova.getEducacao());
        pontuacaoAtual.setFlexibilidade(pontuacaoNova.getFlexibilidade());
        pontuacaoAtual.setInfraestrutura(pontuacaoNova.getInfraestrutura());
        pontuacaoAtual.setLimpeza(pontuacaoNova.getLimpeza());
        pontuacaoAtual.setOrganizacao(pontuacaoNova.getOrganizacao());
        pontuacaoAtual.setProfissionais(pontuacaoNova.getProfissionais());
        pontuacaoAtual.setData(dataAtual);
        pontuacaoAtual.setAtivo(1);  
        
        dao.alterar(pontuacaoAtual);

        request.setAttribute("pontuacao",pontuacaoAtual); 
    }
}  
