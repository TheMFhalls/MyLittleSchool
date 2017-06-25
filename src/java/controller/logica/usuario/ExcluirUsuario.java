package controller.logica.usuario;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
import model.jdbc.DataBase;

public class ExcluirUsuario implements Logica {
    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        UsuarioDao dao = new UsuarioDao(db);
        Usuario usuarioAtual = dao.encontrar(Long.parseLong(pathParts[2]));

        usuarioAtual.setAtivo(0);  

        dao.remover(usuarioAtual);

        request.setAttribute("usuario", usuarioAtual);  
    }
}  
