package controller.logica.pessoa;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pessoa;
import model.dao.pessoa.PessoaDao;
import model.jdbc.DataBase;

public class CadastrarPessoa implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        Long idPessoa = dataAtual.getTime();
        
        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(data, Pessoa.class);
        
        pessoa.setIdPessoa(idPessoa);
        pessoa.setData(dataAtual);
        pessoa.setAtivo(1);

        PessoaDao dao = new PessoaDao(db); 
        
        dao.inserir(pessoa);

        request.setAttribute("pessoa", pessoa); 
    }
}  
