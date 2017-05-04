package controller;

import controller.logica.Logica;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig (maxFileSize    = 256 * 1024 * 1024, // 256MB. Se o tamanho do arquivo ultrapassar esse valor, o container Web envia uma mensagem de erro para o cliente com código HTTP 500 - Erro Interno do Servidor.
                  maxRequestSize = 257 * 1024 * 1024) // 257MB. Se o tamanho da requisicao ultrapassar esse valor, o container Web envia uma mensagem de erro para o cliente com código HTTP 500 - Erro Interno do Servidor.
public class Controlador extends HttpServlet {
  protected void processRequest (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String acao = request.getParameter ("acao");
             
    try {  
      String nomeDaClasse = "controller.logica." + acao;
      Class classe = Class.forName (nomeDaClasse);
      Logica logica = (Logica) classe.newInstance ();
      
      String outro_recurso = logica.executa (request, response);
      
      RequestDispatcher rd = request.getRequestDispatcher (outro_recurso);
      rd.forward (request, response);
    } catch (Exception e) {
      System.out.println ("Erro: classe Controlador - não foi possível executar a lógica de negócio " + acao + ".");
      e.printStackTrace ();
    }   
  }
    
  @Override
  protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      processRequest (request, response);
  }

  @Override
  protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      processRequest (request, response);
  }

  @Override
  public String getServletInfo () {
    return "Short description";
  }
}
