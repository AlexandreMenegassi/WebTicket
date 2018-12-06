<%--
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
        <strong>id Usuario:</strong>
        <p><c:out value="${ticket.idUsuario}"/></p><br>
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

</body>
</html>
