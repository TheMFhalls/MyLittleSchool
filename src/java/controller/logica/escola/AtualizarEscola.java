package controller.logica.escola;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Escola;
import model.dao.escola.EscolaDao;
import model.jdbc.DataBase;

public class AtualizarEscola implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Escola escolaNova = gson.fromJson(data, Escola.class);

        EscolaDao dao = new EscolaDao(db);
        Escola escolaAtual = dao.encontrar(Long.parseLong(pathParts[3]));
        
        escolaAtual.setIdEscola(escolaNova.getIdEscola());
        escolaAtual.setCnpj(escolaNova.getCnpj());
        escolaAtual.setNomeFantasia(escolaNova.getNomeFantasia());
        escolaAtual.setRazaoSocial(escolaNova.getRazaoSocial());
        escolaAtual.setIdEndereco(escolaNova.getIdEndereco());
        escolaAtual.setIdPontuacao(escolaNova.getIdPontuacao());
        escolaAtual.setData(dataAtual);
        escolaAtual.setAtivo(1);  
        
        dao.alterar(escolaAtual);

        request.setAttribute("escola", escolaAtual); 
    }
}  
