package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterLogout implements Filter {  
    public FilterLogout () {
    }  

    @Override
    public void init (FilterConfig arg) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpSession session;       
        session = ((HttpServletRequest) request).getSession();
        session.invalidate();        
        response.getWriter().write("{ \"status\": \"1\", \"mensagem\": \"Usuario deslogado com sucesso!\" }");
    }

    @Override
    public void destroy () {
    }
}
