<!-- Comentário em HTML: -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <c:import url="cabecalho.jsp" />
    
    <main>    
      <%-- Comentário em JSP: Página de Cadastro de Usuários. --%>
      <h1>Cadastro de Usuário</h1>
      <form action="atualizar?acao=usuario.AtualizarUsuario&id=${usuario.id}" method="post">
        <!--input id="id_usr" type="text" name="id" tabindex="1" hidden="hidden" value="${usuario.id}" /-->

        <label for="nome_usr">Nome: </label>
        <input id="nome_usr" type="text" name="nome" tabindex="1" placeholder="${usuario.nome}" />

        <label for="email_usr">E-mail: </label>
        <input id="email_usr" type="email" name="email" tabindex="2" placeholder="${usuario.email}" />

        <label for="nascimento_usr">Data de nascimento: </label>
        <input id="nascimento_usr" type="date" name="datanascimento" tabindex="3" value="${usuario.data_nascimento}" />

        <label for="senha_usr">Senha: </label>
        <input id="senha_usr" type="password" name="senha" tabindex="4" placeholder="${usuario.senha}" /> <br />

        Gêneros preferidos: <br />
        <input id="opcao1" type="checkbox" name="genero" value="suspense" tabindex="5" />
        <label for="opcao1">Suspense.</label> <br />

        <input id="opcao2" type="checkbox" name="genero" value="Comédia" tabindex="6" />
        <label for="opcao2">Comédia.</label> <br />

        <input type="submit" name="Enviar" tabindex="7" />  
      </form>
    </main>    
    
    <c:import url="rodape.jsp" />
  </body>
</html>
