package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroConfirmaLoginUsuario implements Filter {  
  public FiltroConfirmaLoginUsuario () {
  }  
    
  @Override
  public void init (FilterConfig arg) throws ServletException {
  }
  
  @Override
  public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {    
    System.out.println ("-- 02 -- Entrando no filtro: FiltroConfirmaLoginUsuario");
    //System.out.println ("-- 02 -- [Implementação da lógica do filtro: FiltroConfirmaLoginUsuario]");
    
    chain.doFilter (request, response);
    
    System.out.println ("-- 02 -- Saindo do filtro: FiltroConfirmaLoginUsuario");
  }
  
  @Override
  public void destroy () {
  }
}
