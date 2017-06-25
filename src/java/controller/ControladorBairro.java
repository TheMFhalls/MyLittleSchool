package controller;

import controller.logica.Logica;
import controller.logica.bairro.AtualizarBairro;
import controller.logica.bairro.CadastrarBairro;
import controller.logica.bairro.EncontrarBairro;
import controller.logica.bairro.EncontrarEscolaBairro;
import controller.logica.bairro.ExcluirBairro;
import controller.logica.bairro.ExibirBairro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorBairro extends Controlador {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");
            
            if(pathParts.length == 3){
                Logica logica = (Logica) new EncontrarBairro();

                logica.executa(request, response);

                outJson(request, response, "bairro");
            }else if(pathParts.length > 3){
                if("escola".equals(pathParts[3])){
                    Logica logica = (Logica) new EncontrarEscolaBairro();

                    logica.executa(request, response);

                    outJson(request, response, "escolas");
                }                
            }else{
                Logica logica = (Logica) new ExibirBairro();

                logica.executa(request, response);

                outJson(request, response, "bairros");                 
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
            Logica logica = (Logica) new CadastrarBairro();
            
            logica.executa(request, response);
            
            outJson(request, response, "bairro");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new ExcluirBairro();
            
            logica.executa(request, response);

            outJson(request, response, "bairro");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new AtualizarBairro();
            
            logica.executa(request, response);

            outJson(request, response, "bairro");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    */
}
