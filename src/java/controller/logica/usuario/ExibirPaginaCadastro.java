package controller.logica.usuario;

import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibirPaginaCadastro implements Logica {
  @Override
  public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "WEB-INF/view/cadastrarUsuario.jsp";
  }
}
