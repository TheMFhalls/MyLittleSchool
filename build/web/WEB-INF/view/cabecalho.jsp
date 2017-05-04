<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <head>
    <title>Sistema de Vídos Online</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="fig/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/estilo.css" />
  </head>
  <body> 
    <header>
      <i class="fa fa-play-circle-o" aria-hidden="true"></i> Sistema de Vídeos Online sob Demanda
    </header>
    
    <nav>
      <a class="botao" href="controlador?acao=usuario.ExibirPaginaCadastro" tabindex="4" >Cadastrar</a> 
      <a class="botao" href="usuarios?acao=usuario.ExibirUsuarios" tabindex="5" >Listar usuários</a> 
      <a class="botao" href="controlador?acao=video.ExibirPaginaCarregamentoVideo" tabindex="6" >Enviar vídeo</a> 
      <a class="botao" href="videos?acao=video.ExibirVideos" tabindex="5" >Listar videos</a>
    </nav>
