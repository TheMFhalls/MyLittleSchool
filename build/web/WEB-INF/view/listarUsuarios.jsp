<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <c:import url="cabecalho.jsp" />
    
    <main>    
      <%-- Comentário em JSP: Página Dos Usuários Cadastrados. --%>
      <h1>Usuários Cadastrados</h1>

      <table border="1" cellspacing="0" cellpadding="8">
        <thead>
          <tr><th>ID</th><th>Nome</th><th>E-mail</th><th>Senha</th><th>Nascimento</th><th>Atualizar</th><th>Remover</th></tr>
        </thead>
        <!-- percorre a lista de usuários montando as linhas da tabela: -->
        <c:forEach var="usuario" items="${usuarios}">
          <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
            <td>${usuario.senha}</td>
            <td>
              <fmt:parseDate value="${usuario.data_nascimento}" pattern="yyyy-MM-dd" type="date" var="parsedDate" />
              <fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy" type="date" var="formatedDate" />              
              ${formatedDate}
            </td>
            <td><a href="editar?acao=usuario.EditarUsuario&id=${usuario.id}">Editar</a></td>
            <td><a href="excluir?acao=usuario.ExcluirUsuario&id=${usuario.id}">Excluir</a></td>
          </tr>
        </c:forEach>
      </table>
    </main>    
    
    <c:import url="rodape.jsp" />
  </body>
</html>



<!--        

DateTimeFormatter formato = DateTimeFormatter.ofPattern ("dd/MM/yyyy");
        data_nascimento_str = formato.format (u.getData_nascimento ());
        out.println ("Data de nascimento: " + data_nascimento_str + "<br />");
         
-->