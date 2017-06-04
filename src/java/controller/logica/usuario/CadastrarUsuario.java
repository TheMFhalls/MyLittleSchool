package controller.logica.usuario;

import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
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
        Usuario usuario = gson.fromJson(data, Usuario.class);
        
        usuario.setData(dataAtual);
        usuario.setAtivo(1);

        UsuarioDao dao = new UsuarioDao(db); 
        
        dao.inserir(usuario);

        request.setAttribute("usuario", usuario); 
    }
}  
