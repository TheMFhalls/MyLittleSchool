package controller.logica.usuario;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogarUsuario implements Logica {
  @Override
  public String executa (HttpServletRequest req, HttpServletResponse res) throws Exception {
    return "WEB-INF/view/home.jsp";
  }
}
