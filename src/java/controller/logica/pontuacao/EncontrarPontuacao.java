package controller.logica.pontuacao;


import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pontuacao;
import model.dao.pontuacao.PontuacaoDao;
import model.jdbc.DataBase;

public class EncontrarPontuacao implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        PontuacaoDao dao = new PontuacaoDao(db); //Inversão de controle e injeção de dependência.
        Pontuacao pontuacao = dao.encontrar(Long.parseLong(pathParts[3]));

        request.setAttribute("pontuacao", pontuacao);   
    }  
}
