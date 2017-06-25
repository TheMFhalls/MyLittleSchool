package controller.logica.pontuacao;


import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pontuacao;
import model.dao.pontuacao.PontuacaoDao;
import model.jdbc.DataBase;

public class ExcluirPontuacao implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());

        PontuacaoDao dao = new PontuacaoDao(db);
        Pontuacao pontuacaoAtual = dao.encontrar(Long.parseLong(pathParts[2]));

        pontuacaoAtual.setAtivo(0);  

        dao.remover(pontuacaoAtual);

        request.setAttribute("pontuacao", pontuacaoAtual);  
    }
}  
