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
    <title>Altere sua senha</title>
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
<hr>
<form action="/alterarSenha" method="post">
    <div class="form-group">
        <label for="inpsenha1">Senha:</label>
        <input type="text" class="form-control" required id="inpsenha1" name="senha1" value="">
    </div>
    <div class="form-group">
        <label for="inpSenha2">Confirme sua senha</label>
        <input type="text" class="form-control" required id="inpSenha2" name="senha2" value="">
    </div>
    <input type="hidden" name="idUsuario" value="${idUsuario}"/>
    <input type="submit" value="Alterar" class="btn btn-default">
</form>
</body>
</html>
