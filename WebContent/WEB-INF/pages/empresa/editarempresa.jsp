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
    <title>Editar operador</title>
    <!-- Styles -->
    <link href="../../assets/css/lib/weather-icons.css" rel="stylesheet" />
    <link href="../../assets/css/lib/owl.carousel.min.css" rel="stylesheet" />
    <link href="../../assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
    <link href="../../assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="../../assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="../../assets/css/lib/menubar/sidebar.css" rel="stylesheet">
    <link href="../../assets/css/lib/bootstrap.min.css" rel="stylesheet">

    <link href="../../assets/css/lib/helper.css" rel="stylesheet">
    <link href="../../assets/css/style.css" rel="stylesheet">
</head>
<body style="margin:0 auto; width: 1024px">
<div class="navbar">
    <a href="controller?acao=home">Voltar</a>
</div>
<hr>
<form action="/EditarEmpresa" method="post">
    <div class="form-group">
        <label for="inpLogin">Nome</label>
        <input type="text" class="form-control" id="inpNome" name="Nome" value="${empresa.nome}">
    </div>
    <div class="form-group">
        <label for="inpSenha">Razão Social</label>
        <input type="text" class="form-control" id="inpRazaoSocial" name="RazaoSocial" value="${empresa.razaoSocial}">
    </div>
    <div class="form-group">
        <label for="inpSenha">CNPJ</label>
        <input type="text" class="form-control" id="inpCNPJ" name="CNPJ" value="${empresa.cnpj}">
    </div>

    <input type="hidden" name="idEmpresa" value="${empresa.id}"/>
    <input type="submit" value="editar" class="btn btn-default">
</form>
</body>
</html>
