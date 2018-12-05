<%@ page import="br.edu.fapi.webticket.empresa.modelo.Empresa" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gui_S
  Date: 03/12/2018
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Criar Cliente</title>
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
<c:if test="${not empty empresas}">
<form action="/clienteCriar" method="post">
    <div class="form-group">
        <label for="inpLogin">Login</label>
        <input type="text" class="form-control" id="inpLogin" name="login" required>
    </div>
    <div>
        <label for="ddlEmpresa">Empresa</label>
        <select name="idEmpresa" id="ddlEmpresa" class="form-control">
            <c:forEach var="empresa" items="${empresas}">
                <option value="${empresa.id}"><c:out value="${empresa.nome}"/></option>
            </c:forEach>
        </select>
        <div class="form-group">
            <label >A senha 12345 será gerada para este cliente</label>
        </div><br>
    </div>
    <input type="submit" value="criar" class="btn btn-default">
</form>
</c:if>
<c:if test="${empty empresas}">
    <p>Nenhuma empresa cadastrada!</p>
</c:if>
</body>
</html>
