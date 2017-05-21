package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.logica.Logica;
import controller.logica.escola.AtualizarEscola;
import controller.logica.escola.CadastrarEscola;
import controller.logica.escola.EncontrarEscola;
import controller.logica.escola.ExcluirEscola;
import controller.logica.escola.ExibirEscola;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEscola extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 4){
                Logica logica = (Logica) new EncontrarEscola();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("estado"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }else{
                Logica logica = (Logica) new ExibirEscola();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("estados"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);                 
            }                      
        }catch(Exception e){
          System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new CadastrarEscola();
            
            logica.executa(request, response);
            
            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("estado"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new ExcluirEscola();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("estado"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new AtualizarEscola();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("estado"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
}
