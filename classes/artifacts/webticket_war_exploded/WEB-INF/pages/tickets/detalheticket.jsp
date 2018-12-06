<%@ page import="br.edu.fapi.webticket.usuario.modelo.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Gui_S
  Date: 06/12/2018
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Detalhe ticket</title>
    <!-- Styles -->
    <link href="assets/css/lib/weather-icons.css" rel="stylesheet" />
    <link href="assets/css/lib/owl.carousel.min.css" rel="stylesheet" />
    <link href="assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/menubar/sidebar.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">

    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>
<body style="margin:0 auto; width: 1024px">
<div class="navbar">
    <a href="controller?acao=home">Voltar</a>
</div>
<hr>
<div class="panel panel-default">
    <div class="panel-body">
        <strong>Usuario:</strong>
        <p><c:out value="${ticket.usuarioNome}"/></p><br>
        <strong>titulo:</strong><br>
        <p><c:out value="${ticket.titulo}"/></p><br>
        <strong>descricao:</strong><br>
        <p><c:out value="${ticket.descricao}"/></p><br>
        <strong>data criacao:</strong>
        <p><c:out value="${ticket.dataCriacao}"/></p><br>
        <strong>data fechamento:</strong>
        <p><c:out value="${ticket.dataFechamento}"/></p><br>
    </div>
</div>
<hr>
<h4>Respostas</h4>
<hr>
<c:forEach var="ticketConversa" items="${ticketConversas}">
    <div class="panel panel-default">
        <div class="panel-body">
            <h4><c:out value="${ticketConversa.usuarioNome}"/></h4><br>
            <p><c:out value="${ticketConversa.conteudo}"/></p><br>
            <td>Data: <c:out value="${ticketConversa.dataPostagem}"/></td>
        </div>
    </div>
    <hr>
</c:forEach>
<c:if test="${empty ticket.dataFechamento}">
    <%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
    <%if(usuario.isOperador() || usuario.isCliente()){%>
    <form action="ticketDetalhe" method="post">
        <input type="hidden" name="idTicket" value="${ticket.idTicket}"/>
        <textarea style="min-height: 100px" name="resposta" id="txtResposta" class="form form-control"></textarea><br>
        <input type="submit" value="responder" name="acao" class="btn btn-default">
        <%if(usuario.isCliente()){%>
            <input style="float: right" type="submit" value="fechar" name="acao" class="btn btn-danger">
        <%}%>
    </form>
    <%}%>
</c:if>
</body>
</html>
