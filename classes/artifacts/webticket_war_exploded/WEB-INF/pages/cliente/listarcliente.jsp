<%--
  Created by IntelliJ IDEA.
  User: Gui_S
  Date: 02/12/2018
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Lista de Clientes</title>

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
<a href="/clienteController?acao=criar">Criar cliente</a>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Login</th>
        <th>Senha</th>
        <th>Tipo</th>
        <th>Deletar</th>
        <th>Editar</th>
    </tr>
    <tbody>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td><c:out value="${cliente.login}"/></td>
            <td><c:out value="${cliente.senha}"/></td>
            <c:if test="${cliente.admin}">
                <td><p>Administrador</p></td>
            </c:if>
            <c:if test="${cliente.operador}">
                <td><p>Operador</p></td>
            </c:if>
            <c:if test="${cliente.cliente}">
                <td><p>Cliente</p></td>
            </c:if>
            <td>
                <form action="/clienteDeletar" method="post">
                    <input type="hidden" name="idUsuario" value="${cliente.idUsuario}"/>
                    <input class="btn btn-danger" type="submit" value="deletar"/>
                </form>
            </td>
            <td>
                <form action="/clienteEditar" method="get">
                    <input type="hidden" name="idUsuario" value="${cliente.idUsuario}"/>
                    <input class="btn btn-default" type="submit" value="editar"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</table>

</body>
</html>
