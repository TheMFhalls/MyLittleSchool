package controller.logica.pessoa;


import com.google.gson.Gson;
import controller.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Pessoa;
import model.dao.pessoa.PessoaDao;

import model.jdbc.DataBase;

public class AtualizarPessoa implements Logica {
    @Override
    public void executa (HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        DataBase db = (DataBase) request.getAttribute("db");
        String[] pathParts = (String[]) request.getAttribute("pathParts");
        String data = (String) request.getAttribute("data");
        java.util.Date date = new java.util.Date();
        java.sql.Date dataAtual = new java.sql.Date(date.getTime());
        
        Gson gson = new Gson();
        Pessoa pessoaNova = gson.fromJson(data, Pessoa.class);

        PessoaDao dao = new PessoaDao(db);
        Pessoa pessoaAtual = dao.encontrar(Long.parseLong(pathParts[2]));
        
        pessoaAtual.setIdPessoa(Long.parseLong(pathParts[2]));
        pessoaAtual.setNome(pessoaNova.getNome());
        pessoaAtual.setCpf(pessoaNova.getCpf());
        pessoaAtual.setEmail(pessoaNova.getEmail());
        pessoaAtual.setSenha(pessoaNova.getSenha());
        pessoaAtual.setIdEndereco(pessoaNova.getIdEndereco());
        pessoaAtual.setIdResponsavel(pessoaNova.getIdResponsavel()); 
        pessoaAtual.setData(dataAtual);
        pessoaAtual.setAtivo(1);  
        
        dao.alterar(pessoaAtual);

        request.setAttribute("pessoa", pessoaAtual); 
    }
}  
