package controller.logica.usuario;


import controller.logica.estado.*;
import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class AtualizarUsuario implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Estado estadoNovo = gson.fromJson(data, Estado.class);

        EstadoDao dao = new EstadoDao(db);
        Estado estadoAtual = dao.encontrar(Long.parseLong(pathParts[3]));
        
        estadoAtual.setIdEstado(Long.parseLong(pathParts[3]));
        estadoAtual.setNome(estadoNovo.getNome());  
        estadoAtual.setUf(estadoNovo.getUf());  
        estadoAtual.setData(dataAtual);
        estadoAtual.setAtivo(1);  
        
        dao.alterar(estadoAtual);

        request.setAttribute("estado", estadoAtual); 
    }
}  
