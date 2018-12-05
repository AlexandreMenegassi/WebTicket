<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>WebTicket: Login</title>
		
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
					<div class="col-lg-3">
						<div class="login-content">
							<div class="login-logo">
								<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">WebTicket</font></font></span>
							</div>
							<div class="login-form">
								<h4>
									<font style="vertical-align: inherit;"><font style="vertical-align: inherit;">login</font></font>
								</h4>
								<form action="UsuarioLogar" method="post">
									<div class="form-group">
										<label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Endere�o de e-mail</font></font></label>
										<input type="text" name="login"  class="form-control" placeholder="Email">
									</div>
									<div class="form-group">
										<label><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Senha</font></font></label>
										<input type="password" name="senha" class="form-control" placeholder="Password">
									</div>
									<div class="checkbox">
										<label><input type="checkbox"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Lembre-me </font></font></label> <font
											style="vertical-align: inherit;"><label	class="pull-right"><a href="#"><font style="vertical-align: inherit;">Esqueceu a senha?</font></a></label></font><label
											class="pull-right"> <a href="#"><font style="vertical-align: inherit;"></font></a>
										</label>
									</div>
									<button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30"><font style="vertical-align: inherit;"><font
											style="vertical-align: inherit;">entrar</font></font>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>