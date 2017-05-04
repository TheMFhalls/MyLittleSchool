<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer>
  <i class="fa fa-play-circle-o" aria-hidden="true"></i> &copy Sistema de Vídeos Online sob Demanda
  <!--img src="<c:url value='/fig/video.png'/>" height="30vh" /-->  
  
  <%-- A linha de código acima poderia ser substituída por: 
     <c:url value="/fig/video.png" var="imagem" /> 
     <img src="${imagem}" title="${imagem}" height="30vh"/>      
  --%> 
</footer>
      