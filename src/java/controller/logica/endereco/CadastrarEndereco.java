package controller.logica.endereco;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;
import model.jdbc.DataBase;

public class CadastrarEndereco implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(data, Endereco.class);
        
        endereco.setData(dataAtual);
        endereco.setAtivo(1);

        EnderecoDao dao = new EnderecoDao(db); 
        
        dao.inserir(endereco);

        request.setAttribute("endereco", endereco); 
    }
}  
