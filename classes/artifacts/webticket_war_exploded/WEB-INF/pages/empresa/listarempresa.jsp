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
    <title>Lista Empresas</title>

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
<a href="/empresaController?acao=criar">Criar Empresas</a>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Nome</th>
        <th>Razão Social</th>
        <th>CNPJ</th>
        <th>Deletar</th>
        <th>Editar</th>
    </tr>
    <tbody>
    <c:forEach var="empresa" items="${empresas}">
        <tr>
            <td><c:out value="${empresa.nome}"/></td>
            <td><c:out value="${empresa.razaoSocial}"/></td>
            <td><c:out value="${empresa.cnpj}"/></td>


            <td>
                <form action="/DeletarEmpresa" method="post">
                    <input type="hidden" name="idEmpresa" value="${empresa.id}"/>
                    <input class="btn btn-danger" type="submit" value="deletar"/>
                </form>
            </td>
            <td>
                <form action="/EditarEmpresa" method="get">
                    <input type="hidden" name="idEmpresa" value="${empresa.id}"/>
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
