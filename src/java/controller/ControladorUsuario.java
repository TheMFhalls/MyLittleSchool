package controller;

import controller.logica.Logica;
import controller.logica.usuario.AtualizarUsuario;
import controller.logica.usuario.CadastrarUsuario;
import controller.logica.usuario.EncontrarEscolaUsuario;
import controller.logica.usuario.EncontrarPessoaUsuario;
import controller.logica.usuario.EncontrarUsuario;
import controller.logica.usuario.ExcluirUsuario;
import controller.logica.usuario.ExibirUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorUsuario extends Controlador {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         try{
            String[] pathParts = (String[]) request.getAttribute("pathParts");

            if(pathParts.length == 3){
                Logica logica = (Logica) new EncontrarUsuario();

                logica.executa(request, response);                
                
                outJson(request, response, "usuario");
            }else if(pathParts.length > 3){
                if("pessoa".equals(pathParts[3])){
                    Logica logica = (Logica) new EncontrarPessoaUsuario();

                    logica.executa(request, response);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write((String) request.getAttribute("pessoaUsuario"));
                }
                if("escola".equals(pathParts[3])){
                    Logica logica = (Logica) new EncontrarEscolaUsuario();

                    logica.executa(request, response);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write((String) request.getAttribute("escolaUsuario"));
                }
            }else{
                Logica logica = (Logica) new ExibirUsuario();

                logica.executa(request, response);

                outJson(request, response, "usuarios");                 
            }                      
        }catch(Exception e){
          System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new CadastrarUsuario();
            
            logica.executa(request, response);
            
            outJson(request, response, "usuario");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new ExcluirUsuario();
            
            logica.executa(request, response);

            outJson(request, response, "usuario");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }

    @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{            
            Logica logica = (Logica) new AtualizarUsuario();
            
            logica.executa(request, response);

            outJson(request, response, "usuario");
        }catch(Exception e){
            System.out.println ("Erro: classe ControladorEstado - não foi possível executar a lógica de negócio.");
        }
    }
}
