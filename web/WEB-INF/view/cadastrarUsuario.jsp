<!-- Comentário em HTML: -->
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <c:import url="cabecalho.jsp" />
    
    <main>    
      <%-- Comentário em JSP: Página de Cadastro de Usuários. --%>
      <h1>Cadastro de Usuário</h1>
      <form action="cadastrar?acao=usuario.CadastrarUsuario" method="post">
        <label for="nome_usr">Nome: </label>
        <input id="nome_usr" type="text" name="nome" tabindex="1" />

        <label for="email_usr">E-mail: </label>
        <input id="email_usr" type="email" name="email" tabindex="2" />

        <label for="nascimento_usr">Data de nascimento: </label>
        <input id="nascimento_usr" type="date" name="datanascimento" tabindex="3" />

        <label for="senha_usr">Senha: </label>
        <input id="senha_usr" type="password" name="senha" tabindex="4" /> <br />

        Gêneros preferidos: <br />
        <input id="opcao1" type="checkbox" name="genero" value="musica" tabindex="5" /> <label for="opcao1">Música.</label> <br />
        <input id="opcao2" type="checkbox" name="genero" value="aventura" tabindex="6" /> <label for="opcao2">Aventura.</label> <br />
        <input id="opcao3" type="checkbox" name="genero" value="animacao" tabindex="7" /> <label for="opcao3">Animação.</label> <br />

        <input class="botao" type="submit" name="Enviar" tabindex="8" />  
      </form>
    </main>    
    
    <c:import url="rodape.jsp" />
  </body>
</html>
