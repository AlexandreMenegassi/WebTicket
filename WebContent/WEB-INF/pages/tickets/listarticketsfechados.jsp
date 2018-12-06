<%--
  Created by IntelliJ IDEA.
  User: Gui_S
  Date: 05/12/2018
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Listar Tickets Fechados</title>
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

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Titulo</th>
        <th>Descricao</th>
        <th>Usuario</th>
        <th>Data da postagem</th>
        <th>Data do fechamento</th>
        <th>Ver detalhes</th>
        <th>Reabrir</th>
    </tr>
    <tbody>
    <c:forEach var="ticket" items="${tickets}">
        <tr>
            <td><c:out value="${ticket.titulo}"/></td>
            <td><c:out value="${ticket.descricao}"/></td>
            <td><c:out value="${ticket.usuarioNome}"/></td>
            <td><c:out value="${ticket.dataCriacao}"/></td>
            <td><c:out value="${ticket.dataFechamento}"/></td>
            <td>
                <form action="ticketDetalhe" method="get">
                    <input type="hidden" name="idTicket" value="${ticket.idTicket}"/>
                    <input class="btn btn-default" type="submit" value="ver detalhes"/>
                </form>
            </td>
            <td>
                <form action="ticketReabrir" method="get">
                    <input type="hidden" name="idTicket" value="${ticket.idTicket}"/>
                    <input class="btn btn-default" type="submit" value="Reabrir"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
