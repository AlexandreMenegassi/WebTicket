<%@ page import="br.edu.fapi.webticket.usuario.modelo.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="ISO-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>WebTicket: Home</title>

        <!-- ================= Favicon ================== -->
        <!-- Standard -->
        <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
        <!-- Retina iPad Touch Icon-->
        <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
        <!-- Retina iPhone Touch Icon-->
        <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
        <!-- Standard iPad Touch Icon-->
        <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
        <!-- Standard iPhone Touch Icon-->
        <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

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
<body>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
        <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
            <div class="nano">
                <div class="nano-content">
                    <div class="logo"><a href="login.jsp"><span>WebTicket</span></a></div>
                    <ul>
                        <li class="label">Menu</li>
                        <li class="active"><a class="sidebar-sub-toggle"><i class="ti-home"></i> Dashboard <span class="badge badge-primary">4</span> <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                                <li><a href="#">Administrador</a></li>
                                <li><a href="#">Operador</a></li>
                                <li><a href="#">Cliente</a></li>
                                <li><a href="#">Usuário</a></li>                        
                            </ul>
                        </li>
                        <li class="label">Usuário</li>
                        <li><a href="#"><i class="ti-files"></i> Novo Tópico </a></li>
                        <li><a href="#"><i class="ti-files"></i> Listar Tópicos</a></li>
                        <li><a href="#"><i class="ti-files"></i> Responder Tópicos</a></li>

                        <%if(usuario.isCliente()){%>
                        <li class="label">Cliente</li>
                        <li class="active"><a class="sidebar-sub-toggle"><i class="ti-files"></i> Tickets <span class="badge badge-primary">4</span> <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                                <li><a href="#">Listar todos os tickets resolvidos</a></li>
                                <li><a href="#">Listar todos os tickets não resolvidos</a></li>
                                <li><a href="#">Visualizar ou editar ticket</a></li>                        
                            </ul>
                        </li>
                        <li><a href="#"><i class="ti-files"></i> Criar Ticket </a></li>
                        <li><a href="#"><i class="ti-files"></i> Listar Tópicos em Abertos</a></li>
                        <li><a href="#"><i class="ti-files"></i> Contribuir com uma Dúvida</a></li>
                        <%}%>
                        <%if(usuario.isOperador()){%>
                        <li class="label">Operador</li>
                        <li><a href="empresaController?acao=manter"><i class="ti-files"></i> Gerênciar Empresas </a></li>
                        <li><a href="#"><i class="ti-files"></i> Cadastrar Empresas </a></li>
                        <li><a href="#"><i class="ti-files"></i> Agrupar Clientes </a></li>
                        <li><a href="clienteController?acao=manter"><i class="ti-files"></i>Gerênciar Clientes</a></li>
                        <li><a href="#"><i class="ti-files"></i> Responder um Ticket </a></li>
                        <li><a href="#"><i class="ti-files"></i> Responder um Tópico</a></li>
						<li class="active"><a class="sidebar-sub-toggle"><i class="ti-files"></i> Relatórios <span class="badge badge-primary">9</span> <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                                <li><a href="#">Clientes</a></li>
                                <li><a href="#">Usuários no sistema</a></li>
                                <li><a href="#">Clientes por empresa</a></li>  
                                <li><a href="#">Quantidade de tickets por clientes</a></li>       
                                <li><a href="#">Quantidade de tickets por clientes sem respostas</a></li>
                                <li><a href="#">Quantidade de tickets resolvidos por cliente</a></li>
                                <li><a href="#">Quantidade de tickets reaberto por cliente</a></li>  
                                <li><a href="#">Quantidade de tópicos por usuário</a></li>
                                <li><a href="#">Quantidade de tópicos sem respostas</a></li>
                                <li><a href="#">Quantidade de tópicos marcado como resolvido</a></li>              
                            </ul>
                        </li>
                        <%}%>
                        <%if(usuario.isAdmin()){%>
                        <li class="label">Administrador</li>
                        <li class="active"><a class="sidebar-sub-toggle"><i class="ti-files"></i> Operador Tickets <span class="badge badge-primary">3</span> <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                                <li><a href="#">Editar resposta de um operador</a></li>
                                <li><a href="#">Data de edição da resposta</a></li> 
                                <li><a href="#">Quantidade de tickets resolvido por operador</a></li>                 
                            </ul>
                        </li>
                        <li><a href="operadorController?acao=manter"><i class="ti-files"></i> Gerênciar Operadores </a></li>
                        <li><a href="#"><i class="ti-files"></i> Relatórios de Operadores</a></li>
                        <li><a href="#"><i class="ti-files"></i> Relatórios Administrativos</a></li>
						<li><a href="#"><i class="ti-files"></i> Log de Acesso</a></li>
                        <%}%>

                        <li><a href="index.jsp"><i class="ti-close"></i> Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="content-wrap">
            <div class="main">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-8 p-r-0 title-margin-right">
                            <div class="page-header">
                                <div class="page-title">
                                    <h1>Hello, <span>Welcome Here</span></h1>
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                        <div class="col-lg-4 p-l-0 title-margin-left">
                            <div class="page-header">
                                <div class="page-title">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Home</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->
                    
                </div>
            </div>
        </div>
        <div id="search">
            <button type="button" class="close">×</button>
            <form>
                <input type="search" value="" placeholder="type keyword(s) here" />
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
        <!-- jquery vendor -->
        <script src="assets/js/lib/jquery.min.js"></script>
        <script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
        <!-- nano scroller -->
        <script src="assets/js/lib/menubar/sidebar.js"></script>
        <script src="assets/js/lib/preloader/pace.min.js"></script>
        <!-- sidebar -->
        <script src="assets/js/lib/bootstrap.min.js"></script>

        <!-- bootstrap -->

        <script src="assets/js/lib/circle-progress/circle-progress.min.js"></script>
        <script src="assets/js/lib/circle-progress/circle-progress-init.js"></script>

        <script src="assets/js/lib/morris-chart/raphael-min.js"></script>
        <script src="assets/js/lib/morris-chart/morris.js"></script>
        <script src="assets/js/lib/morris-chart/morris-init.js"></script>

        <!--  flot-chart js -->
        <script src="assets/js/lib/flot-chart/jquery.flot.js"></script>
        <script src="assets/js/lib/flot-chart/jquery.flot.resize.js"></script>
        <script src="assets/js/lib/flot-chart/flot-chart-init.js"></script>
        <!-- // flot-chart js -->


        <script src="assets/js/lib/vector-map/jquery.vmap.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/jquery.vmap.min.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/jquery.vmap.sampledata.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.world.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.algeria.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.argentina.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.brazil.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.france.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.germany.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.greece.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.iran.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.iraq.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.russia.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.tunisia.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.europe.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/country/jquery.vmap.usa.js"></script>
        <!-- scripit init-->
        <script src="assets/js/lib/vector-map/vector.init.js"></script>

        <script src="assets/js/lib/weather/jquery.simpleWeather.min.js"></script>
        <script src="assets/js/lib/weather/weather-init.js"></script>
        <script src="assets/js/lib/owl-carousel/owl.carousel-init.js"></script>
        <script src="assets/js/lib/owl-carousel/owl.carousel.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <!-- scripit init-->

    </body>
</html>