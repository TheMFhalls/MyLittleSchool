package controller;

import controller.logica.Logica;
import controller.logica.estado.AtualizarEstado;
import controller.logica.estado.CadastrarEstado;
import controller.logica.estado.EncontrarCidadeEstado;
import controller.logica.estado.EncontrarEstado;
import controller.logica.estado.ExcluirEstado;
import controller.logica.estado.ExibirEstado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEstado extends Controlador {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 4){
                Logica logica = (Logica) new EncontrarEstado();

                logica.executa(request, response);                
                
                outJson(request, response, "estado");
            }else if(pathParts.length > 4){
                switch(pathParts[4]){
                    case "cidade":
                        Logica logica = (Logica) new EncontrarCidadeEstado();

                        logica.executa(request, response);

                        outJson(request, response, "cidades");
                    break;
                }                
            }else{
                Logica logica = (Logica) new ExibirEstado();

                logica.executa(request, response);

                outJson(request, response, "estados");                 
            }                      
        }catch(Exception e){
          System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    /*
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new CadastrarEstado();
            
            logica.executa(request, response);
            
            outJson(request, response, "estado");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    */
    /*
    @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new ExcluirEstado();
            
            logica.executa(request, response);

            outJson(request, response, "estado");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    */
    /*
    @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new AtualizarEstado();
            
            logica.executa(request, response);

            outJson(request, response, "estado");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    */
}
