package filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import functions.Login;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.jdbc.DataBase;

public class FilterLogin implements Filter {  
    public FilterLogin () {
    }  

    @Override
    public void init (FilterConfig arg) throws ServletException {
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpSession session;
        Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        ResultSet rs;       
        
        String query = "SELECT idUsuario FROM dbMLS.usuario WHERE login = ? AND senha = ?";
        Login login = gson.fromJson(data, Login.class); 
        
        if(
            !"".equals(login.getLogin()) &&
            !"".equals(login.getSenha())
        ){
            try{
                PreparedStatement ps = db.getConexao().prepareStatement(query);            
                ps.setString(1, login.getLogin());
                ps.setString(2, login.getSenha());
                rs = ps.executeQuery();
                
                if(rs.next()){
                    session = ((HttpServletRequest) request).getSession();
                    session.setAttribute("idUsuario", rs.getString("idUsuario"));
                    login.setLogin(rs.getString("idUsuario"));
                    login.setSenha("");
                    login.setStatus(1);
                    login.setMensagem("Login realizado com sucesso!");           
                    response.getWriter().write(json.toJson(login));
                }else{
                    login.setLogin("");
                    login.setSenha("");
                    login.setStatus(0);
                    login.setMensagem("Usuario e senha inválidos!");           
                    response.getWriter().write(json.toJson(login));
                }
            }catch(SQLException ex){
                login.setLogin("");
                login.setSenha("");
                login.setStatus(0);
                login.setMensagem("Erro ao executar a consulta! {"+ex.getMessage()+"}");           
                response.getWriter().write(json.toJson(login));
            }
        }else{           
            login.setLogin("");
            login.setSenha("");
            login.setStatus(0);
            login.setMensagem("Favor, informe seu login e senha!");           
            response.getWriter().write(json.toJson(login));
        }
    }

    @Override
    public void destroy () {
    }
}
