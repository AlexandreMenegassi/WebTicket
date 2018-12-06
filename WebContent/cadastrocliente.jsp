<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cadastro de Clientes</title>

    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144"
          href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114"
          href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72"
          href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57"
          href="http://placehold.it/57.png/000/fff">

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
<body class="bg-primary">
<div class="unix-login">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="index.jsp"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">WebTicket</font></font></span></a>
                    </div>
                    <div class="login-form">
                        <h4>
                            <font style="vertical-align: inherit;"><font style="vertical-align: inherit;">preencha com seus dados</font></font>
                        </h4>
                        <form action="VerificarUsuario" method="post">
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Nome</font></font></label>
                                <input type="text" name="nome"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Sobrenome</font></font></label>
                                <input type="text" name="sobrenome"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Idade</font></font></label>
                                <input type="text" name="idade"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Sexo</font></font></label>
                                <input type="text" name="sexo"  class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">RG</font></font></label>
                                <input type="text" name="rg"  class="form-control">
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">CPF</font></font></label>
                                <input type="text" name="cpf"  class="form-control">
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Digite um nome de Login</font></font></label>
                                <input type="text" name="login"  class="form-control" required >
                            </div>
                            <div class="form-group">
                                <label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">PRIMEIRA SENHA DE ACESSO SERÁ: 12345 </font></font></label>

                            </div>
                            <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30"><font style="vertical-align: inherit;"><font
                                    style="vertical-align: inherit;">Cadastrar</font></font>
                            </button>
                        </form>
                        <div style="text-align: center;">
                            <% if (session.getAttribute("userDuplicado") != null) {%>
                            <p> <%= session.getAttribute("userDuplicado") %> </p>
                            <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
