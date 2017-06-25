package controller.logica.usuario;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.usuario.UsuarioDao;
import model.jdbc.DataBase;

public class EncontrarUsuario implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");

        UsuarioDao dao = new UsuarioDao(db); //Inversão de controle e injeção de dependência.
        Usuario usuario = dao.encontrar(Long.parseLong(pathParts[2]));

        request.setAttribute("usuario", usuario);   
    }  
}
