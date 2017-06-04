package controller.logica.usuario;


import controller.logica.estado.*;
import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Estado;
import model.dao.estado.EstadoDao;
import model.jdbc.DataBase;

public class CadastrarUsuario implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Estado estado = gson.fromJson(data, Estado.class);
        
        estado.setData(dataAtual);
        estado.setAtivo(1);

        EstadoDao dao = new EstadoDao(db); 
        
        dao.inserir(estado);

        request.setAttribute("estado", estado); 
    }
}  
