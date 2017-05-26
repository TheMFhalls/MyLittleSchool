package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.logica.Logica;
import controller.logica.cidade.AtualizarCidade;
import controller.logica.cidade.CadastrarCidade;
import controller.logica.cidade.EncontrarCidade;
import controller.logica.cidade.ExcluirCidade;
import controller.logica.cidade.ExibirCidade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorCidade extends Controlador {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 4){
                Logica logica = (Logica) new EncontrarCidade();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("cidade"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }else{
                Logica logica = (Logica) new ExibirCidade();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("cidades"));
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
            Logica logica = (Logica) new CadastrarCidade();
            
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
            Logica logica = (Logica) new ExcluirCidade();
            
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
            Logica logica = (Logica) new AtualizarCidade();
            
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
