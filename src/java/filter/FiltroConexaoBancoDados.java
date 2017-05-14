package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import model.jdbc.DataBase;
import model.jdbc.DataBaseFactory;

public class FiltroConexaoBancoDados implements Filter {  
    public FiltroConexaoBancoDados () {
    }  

    @Override
    public void init (FilterConfig arg) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        DataBase db = DataBaseFactory.getDataBase("MySql", "heredes", "Kgggdkp159753", "dbMLS");

        db.abrirConexao();

        request.setAttribute("db", db);

        chain.doFilter(request, response);

        db.fecharConexao();
    }

    @Override
    public void destroy () {
    }
}
