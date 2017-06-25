package controller;

import controller.logica.Logica;
import controller.logica.escola.AtualizarEscola;
import controller.logica.escola.CadastrarEscola;
import controller.logica.escola.EncontrarEnderecoEscola;
import controller.logica.escola.EncontrarEscola;
import controller.logica.escola.EncontrarPontuacaoEscola;
import controller.logica.escola.ExcluirEscola;
import controller.logica.escola.ExibirEscola;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEscola extends Controlador {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");
            
            if(pathParts.length == 4){
                Logica logica = (Logica) new EncontrarEscola();

                logica.executa(request, response);

                outJson(request, response, "escola");
            }else if(pathParts.length > 4){
                if("endereco".equals(pathParts[4])){
                    Logica logicaEnderecos = (Logica) new EncontrarEnderecoEscola();

                    logicaEnderecos.executa(request, response);

                    outJson(request, response, "endereco");
                }else if("pontuacao".equals(pathParts[4])){
                    Logica logicaPontuacao = (Logica) new EncontrarPontuacaoEscola();

                    logicaPontuacao.executa(request, response);

                    outJson(request, response, "pontuacao");
                }                
            }else{
                Logica logica = (Logica) new ExibirEscola();

                logica.executa(request, response);

                outJson(request, response, "escolas");               
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
            
            outJson(request, response, "escola");
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

            outJson(request, response, "escola");
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

            outJson(request, response, "escola");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
}
