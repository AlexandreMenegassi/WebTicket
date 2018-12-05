<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Criar empresa</title>
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
<form action="/CriarEmpresa" method="post">
    <div class="form-group">
        <label for="inpNome">Nome</label>
        <input type="text" class="form-control" id="inpNome" name="Nome">
    </div>
    <div class="form-group">
        <label for="inpRazaoSocial">Razao Social</label>
        <input type="text" class="form-control" id="inpRazaoSocial" name="RazaoSocial">
    </div>
    <div class="form-group">
        <label for="inpCNPJ">CNPJ</label>
        <input type="text" class="form-control" id="inpCNPJ" name="CNPJ">
    </div>
    <input type="submit" value="criar" class="btn btn-default">
</form>
</body>
</html>