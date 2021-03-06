package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import model.jdbc.DataBase;
import model.jdbc.DataBaseFactory;

public class FiltroSessao implements Filter {  
    public FiltroSessao () {
    }  

    @Override
    public void init (FilterConfig arg) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpSession session;
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy () {
    }
}
