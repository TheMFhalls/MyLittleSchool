package controller;

import controller.logica.Logica;
import controller.logica.cidade.AtualizarCidade;
import controller.logica.cidade.CadastrarCidade;
import controller.logica.cidade.EncontrarBairroCidade;
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

                outJson(request, response, "cidade");  
            }else if(pathParts.length > 4){
                if("bairro".equals(pathParts[4])){
                    Logica logica = (Logica) new EncontrarBairroCidade();

                    logica.executa(request, response);

                    outJson(request, response, "bairros");
                }                
            }else{
                Logica logica = (Logica) new ExibirCidade();

                logica.executa(request, response);

                outJson(request, response, "cidades");                
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
            Logica logica = (Logica) new CadastrarCidade();
            
            logica.executa(request, response);
            
            outJson(request, response, "cidade");  
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

            outJson(request, response, "cidade");  
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

            outJson(request, response, "cidade");  
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
    */
}
