package filter;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroParametros implements Filter {  
    public FiltroParametros () {
    }  

    @Override
    public void init (FilterConfig arg) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {    
        try{
            String[] pathParts = getPathParts((HttpServletRequest) request);
            String data = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            
            request.setAttribute("pathParts", pathParts);
            request.setAttribute("data", data);
            
            chain.doFilter(request, response);
        }catch(IOException | ServletException e){
            System.out.println("Erro: classe FiltroParametros - não foi reculperar os parametros da requisição.");
        }        
    }

    @Override
    public void destroy () {
    }
    
    protected String[] getPathParts(HttpServletRequest request)
        throws ServletException, IOException {
        String[] pathParts = null;

        try{
            String pathInfo = request.getRequestURI();
            pathParts = pathInfo.split("/");            
        }catch(Exception e){
            System.out.println("Erro: classe FiltroParametros - não foi reculperar os parametros da requisição.");
        }

        return pathParts;
    }
}
