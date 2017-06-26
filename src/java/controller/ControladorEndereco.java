package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.logica.Logica;
import controller.logica.endereco.AtualizarEndereco;
import controller.logica.endereco.CadastrarEndereco;
import controller.logica.endereco.EncontrarEndereco;
import controller.logica.endereco.ExcluirEndereco;
import controller.logica.endereco.ExibirEndereco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEndereco extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 3){
                Logica logica = (Logica) new EncontrarEndereco();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("estado"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }else{
                Logica logica = (Logica) new ExibirEndereco();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("enderecos"));
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
            Logica logica = (Logica) new CadastrarEndereco();
            
            logica.executa(request, response);
            
            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("endereco"));
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
            Logica logica = (Logica) new ExcluirEndereco();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("endereco"));
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
            Logica logica = (Logica) new AtualizarEndereco();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("endereco"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
}
