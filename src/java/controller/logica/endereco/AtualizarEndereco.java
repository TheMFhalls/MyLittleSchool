package controller.logica.endereco;



import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.endereco.EnderecoDao;
import model.jdbc.DataBase;

public class AtualizarEndereco implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Endereco enderecoNovo = gson.fromJson(data, Endereco.class);

        EnderecoDao dao = new EnderecoDao(db);
        Endereco enderecoAtual = dao.encontrar(Long.parseLong(pathParts[3]));
        
        enderecoAtual.setIdEndereco(enderecoNovo.getIdEndereco());
        enderecoAtual.setIdBairro(enderecoNovo.getIdBairro());
        enderecoAtual.setNome(enderecoNovo.getNome());
        enderecoAtual.setLogradouro(enderecoNovo.getLogradouro());
        enderecoAtual.setNumero(enderecoNovo.getNumero());
        enderecoAtual.setComplemento(enderecoNovo.getComplemento());
        enderecoAtual.setData(dataAtual);
        enderecoAtual.setAtivo(1);  
        
        dao.alterar(enderecoAtual);

        request.setAttribute("endereco", enderecoAtual); 
    }
}  
