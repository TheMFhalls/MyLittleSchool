package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.logica.Logica;
import controller.logica.pontuacao.AtualizarPontuacao;
import controller.logica.pontuacao.CadastrarPontuacao;
import controller.logica.pontuacao.EncontrarPontuacao;
import controller.logica.pontuacao.ExcluirPontuacao;
import controller.logica.pontuacao.ExibirPontuacao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorPontuacao extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 3){
                Logica logica = (Logica) new EncontrarPontuacao();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("pontuacao"));
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }else{
                Logica logica = (Logica) new ExibirPontuacao();

                logica.executa(request, response);

                Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
                String data = json.toJson(request.getAttribute("pontuacoes"));
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
            Logica logica = (Logica) new CadastrarPontuacao();
            
            logica.executa(request, response);
            
            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("pontuacao"));
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
            Logica logica = (Logica) new ExcluirPontuacao();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("pontuacao"));
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
            Logica logica = (Logica) new AtualizarPontuacao();
            
            logica.executa(request, response);

            Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
            String data = json.toJson(request.getAttribute("pontuacao"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
}
