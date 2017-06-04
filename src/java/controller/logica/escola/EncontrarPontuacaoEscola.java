package controller.logica.escola;

import controller.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pontuacao;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class EncontrarPontuacaoEscola implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {        
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        EscolaDao dao = new EscolaDao(db); //Inversão de controle e injeção de dependência.
        List<Pontuacao> pontuacao = dao.encontrarPontuacaoEscola(Long.parseLong(pathParts[3]));

        request.setAttribute("pontuacao", pontuacao);
    }  
}
