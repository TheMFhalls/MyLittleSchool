package controller.logica.usuario;

import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
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
        Usuario usuarioNovo = gson.fromJson(data, Usuario.class);

        UsuarioDao dao = new UsuarioDao(db);
        Usuario usuarioAtual = dao.encontrar(Long.parseLong(pathParts[2]));
        
        usuarioAtual.setIdUsuario(Long.parseLong(pathParts[2]));
        usuarioAtual.setLogin(usuarioNovo.getLogin());  
        usuarioAtual.setSenha(usuarioNovo.getSenha());
        usuarioAtual.setEmail(usuarioNovo.getEmail());  
        usuarioAtual.setData(dataAtual);
        usuarioAtual.setAtivo(1);  
        
        dao.alterar(usuarioAtual);

        request.setAttribute("usuario", usuarioAtual); 
    }
}  
