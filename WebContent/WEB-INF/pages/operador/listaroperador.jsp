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
    <title>Lista operador</title>

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
<body>
    <table>
        <table>
            <tr>
                <th>Login</th>
                <th>Senha</th>
                <th>Admin</th>
                <th>Operador</th>
                <th>Usuario</th>
            </tr>
            <tbody>
            <c:forEach var="item" items="operadores">
                <tr>
                    <td><c:out value="${Login}"/></td>
                    <td><c:out value="${Senha}"/></td>
                    <td><c:out value="${Admin}"/></td>
                    <td><c:out value="${Operador}"/></td>
                    <td><c:out value="${Cliente}"/></td>
                </tr>
            </c:forEach>
            </tbody>
    </table>

</body>
</html>
