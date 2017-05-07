package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig (maxFileSize    = 256 * 1024 * 1024, maxRequestSize = 257 * 1024 * 1024)
public class Controlador extends HttpServlet {
    protected String[] getPathParts(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String[] pathParts = null;
                
        try{
            String pathInfo = request.getRequestURI();
            pathParts = pathInfo.split("/");            
        }catch(Exception e){
          System.out.println ("Erro: classe Controlador - não foi possível executar a lógica de negócio.");
          e.printStackTrace ();
        }
        
        return pathParts;
    }
}
