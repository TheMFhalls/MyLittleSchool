<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <c:import url="WEB-INF/view/cabecalho.jsp" />
    
    <main>
      <fieldset>
        <legend>Login</legend>
        <form action="logar?acao=LogarUsuario" method="post">  
          <label>Nome: <input type="text" name="nome" tabindex="1" /></label>        
          <label>Senha: <input type="password" name="senha" tabindex="2" /><label>   
          <input type="submit" value="Enviar" tabindex="3" >  
        </form>  
      </fieldset>
    </main>
    
    <c:import url="WEB-INF/view/rodape.jsp" />
  </body>
</html>


<%--
Diretivas JSP:

--------------------------------------------------------------------------------
1) Diretiva Page: declara informções sobre a página.
--------------------------------------------------------------------------------

Sintaxe:
--------
<%@ page atributo1=”valor1” atributo2=”valor2” atributo3=”valor3” ... %> 
ou
<jsp:directive.page atributo1=”valor1” atributo2=”valor2” atributo3=”valor3” ... />

Os 11 Atributos da Diretiva Page:
---------------------------------

- Atributo Info: usado para inserir informações sumarizadas da página, não há 
                 restrições quanto ao tamanho de seu valor. Exemplo:
                 <%@ page info="Relação das Diretivas JSP." %>

- Atributo Language: usado, em geral, para especificar Java como a linguagem de 
                     criação de script na página. Exemplo:
                     <%@ page language="java" %>

- Atributo ContentType: indica qual o tipo MIME (Multipurpose Internet Mail 
                        Extensions) da resposta está sendo gerada pela JSP. Os 
                        tipos MIME mais comuns são: "text/plain", "text/html", 
                        "text/xml". Exemplo:
                        <%@ page contentType="text/html" %>

- Atributo Extends: indica a super classe que será usada pelo container no 
                    momento de conversão da página em um Servlet Java. Exemplo:
                    <%@ page extends="com.taglib.jsp.primeirapagina" %>

- Atributo Import: diferentemente do extends, importa um conjunto de classes 
                   Java que poderão ser usadas na página JSP. Funciona como os
                   imports em classes Java. Exemplo:
                   <%@ page import="java.util.*, java.text.*" %>
                   ou
                   <%@ page import="java.util.*" %>
                   <%@ page import="java.text.*" %>

- Atributo Session: session é do tipo boolean e indica se a página está 
                    participando do gerenciamento de sessão. Por exemplo, se 
                    quisermos declarar que uma página é parte de uma sessão, 
                    utilizamos a seguinte sintaxe:
                    <%@ page session="true" %>

- Atributo Buffer: responsável por controlar a saída bufferizada para uma página
                   JSP. Se for ajustado para "none" o conteúdo de uma JSP é 
                   passado instantaneamente à resposta HTTP. O tamanho do buffer
                   é descrito em kilobytes. Exemplo:
                   <%@ page buffer="12kb" %> 
                   ou
                   <%@ page buffer="none" %>

- Atributo AutoFlush: semelhante ao Buffer. Também é responsável por controlar a
                      saída buferizada, mais exatamente o comportamento do 
                      container JSP quando o buffer de saída já está cheio. 
                      Nesse caso o buffer de saída é esvaziado automaticamente e
                      o conteúdo é enviado para o servidor HTTP que transmite 
                      para o navegador responsável pela solicitação. É do tipo 
                      boolean. Exemplo:
                      <%@ page autoFlush="true" %>

- Atributo isThreadSafe: quando uma página JSP é compilada em um Servlet, ela 
                         deve ser capaz de atender a múltiplas solicitações. 
                         Caso seja necessário mudar isso, é preciso ajustar o 
                         valor do atributo isThreadSafe para "false". O valor
                         default desse atribute é "true". Exemplo:
                         <%@ page isThreadSafe="false" %>

- Atributo errorPage: indica uma página alternativa que será exibida caso 
                      aconteça um erro durante o processamento de uma página JSP
                      no container. Exemplo:
                      <%@ page errorPage="projeto/paginas/erro.jsp" %>

- Atributo isErrorPage: define uma página JSP como página de erro padrão. É do 
                        tipo boolean. Exemplo:
                        <%@ page isErrorPage="true" %>

--------------------------------------------------------------------------------
2) Diretiva Include: inclui o conteúdo de um arquivo em outro. Não há limite 
                     para inclusões, pode haver várias em uma mesma página. A 
                     diretiva include é substituída pelo conteúdo que ela 
                     referencia.
--------------------------------------------------------------------------------

Sintaxe:
-------- 
<%@ include file="URLdoArquivo" %> 
ou
<jsp:directive.include file="URLdo Arquivo" />

--------------------------------------------------------------------------------
3) Diretiva Taglib: permite que uma biblioteca de tags personalizadas sejam 
                    usadas numa página JSP, como a JavaServer Pages Standard Tag
                    Library (JSTL). O GlassFish Server inclui a biblioteca JSTL 
                    por default. Você pode verificar isso expandindo o nó do 
                    GlassFish Server no nó de Bibliotecas, na janela Projetos e 
                    procurando a biblioteca javax.servlet.jsp.jstl-api.jar. No 
                    caso do TomCat, é preciso baixar o arquivo .jar da JSTL e 
                    colocá-lo na pasta WEB-INF, dentro de uma pasta
                    com nome lib.
--------------------------------------------------------------------------------

Sintaxe:
-------- 
<%@ taglib uri="URLdaBibliotecadeTags" prefix="PrefixodaTag" %> 
ou
<jsp:directive.taglib uri="URLdaBibliotecadeTags" prefix="PrefixodaTag" />

--%>

