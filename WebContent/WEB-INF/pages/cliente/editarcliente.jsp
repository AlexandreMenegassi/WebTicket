<%--
  Created by IntelliJ IDEA.
  User: Gui_S
  Date: 04/12/2018
  Time: 02:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Cliente</title>
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
<form action="/clienteEditar" method="post">
    <div class="form-group">
        <label for="inpLogin">Login</label>
        <input type="text" class="form-control" id="inpLogin" name="login" value="${cliente.login}" required>
    </div>
    <div class="form-group">
        <label for="inpSenha">senha</label>
        <input type="text" class="form-control" id="inpSenha" name="senha" value="${cliente.senha}" required>
    </div>
    <input type="hidden" name="idUsuario" value="${cliente.idUsuario}"/>
    <input type="submit" value="editar" class="btn btn-default">
</form>
</body>
</html>
