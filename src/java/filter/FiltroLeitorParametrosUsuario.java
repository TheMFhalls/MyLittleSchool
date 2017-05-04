package filter;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import model.bean.Usuario;

public class FiltroLeitorParametrosUsuario implements Filter {  
  public FiltroLeitorParametrosUsuario () {
  }  
    
  @Override
  public void init (FilterConfig arg) throws ServletException {
  }
  
  @Override
  public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {    
    System.out.println ("-- 03 -- Entrando no filtro: FiltroLeitorParametrosUsuario");
    
    //Lógica do filtro: FiltroLeitorParametrosUsuario:
    Usuario usuario = new Usuario ();  
    
    //usuario.setId (Long.valueOf (request.getParameter ("id")));
    usuario.setNome (request.getParameter ("nome"));
    usuario.setEmail (request.getParameter ("email"));
    usuario.setSenha (request.getParameter ("senha"));
    usuario.setGeneros (request.getParameterValues ("genero")); 
    String data_nascimento_str = request.getParameter ("datanascimento");
            
    LocalDate data_nascimento = LocalDate.parse (data_nascimento_str);
    usuario.setData_nascimento (data_nascimento);
    
    request.setAttribute ("usuario", usuario);
    
    chain.doFilter (request, response);
    
    System.out.println ("-- 03 -- Saindo do filtro: FiltroLeitorParametrosUsuario");
  }
  
  @Override
  public void destroy () {
  }
}
