<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%if(session.getAttribute("user")!= null){ %> <!-- si lo quito peta en fondos, sino lo quito me va a inicio -->
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Proyecto_final</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Bitter:400,700">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
<link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/ionicons.min.css">
<link rel="stylesheet"
	href="assets/fonts/fontawesome5-overrides.min.css">
<link rel="stylesheet" href="assets/css/Article-Clean.css">
<link rel="stylesheet" href="assets/css/Article-List.css">
<link rel="stylesheet" href="assets/css/blog-1.css">
<link rel="stylesheet" href="assets/css/blog.css">
<link rel="stylesheet"
	href="assets/css/Bootstrap-4---Table-Fixed-Header.css">
<link rel="stylesheet" href="assets/css/Bootstrap-DataTables.css">
<link rel="stylesheet" href="assets/css/Data-Table-1.css">
<link rel="stylesheet" href="assets/css/Data-Table.css">
<link rel="stylesheet" href="assets/css/Features-Boxed.css">
<link rel="stylesheet" href="assets/css/Footer-Dark.css">
<link rel="stylesheet" href="assets/css/Header-Blue.css">
<link rel="stylesheet" href="assets/css/Header-Dark.css">
<link rel="stylesheet" href="assets/css/Highlight-Phone.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/css/Latest-Blog.css">
<link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
<link rel="stylesheet" href="assets/css/Navigation-Clean.css">
<link rel="stylesheet" href="assets/css/Navigation-with-Button.css">
<link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
<link rel="stylesheet" href="assets/css/Projects-Clean.css">
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/Team-Boxed.css">
</head>

<body>
	<nav
		class="navbar navbar-light navbar-expand-md sticky-top navigation-clean"
		style="box-shadow: 0px 0px 6px 0px; opacity: 0.90;">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><img
				src="assets/img/Main%20logo.png" style="width: 149px;"></a>
			<button data-toggle="collapse" class="navbar-toggler"
				data-target="#navcol-1">
				<span class="sr-only">Toggle navigation</span><span
					class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navcol-1">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link active" href="#">Mercado</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Academia</a></li>
					<li class="nav-item"><a class="nav-link" href="./controller?accion=ranking">Ranking</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Perfil&nbsp;<i
							class="fa fa-user" style="color: #2a076e;"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-bell" style="color: #2a076e;"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="#">EUR</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row no-gutters register-form">
		<div class="col-md-8 offset-md-2">
			<form action="./controller?accion=insertar" method="post" id="profile" onsubmit="return profileValidate()" name="prof" class="custom-form" >
				<h1 style="border-bottom-style: none;">Rellenar Perfil</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="email-input-field">Email
						</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputEmail" class="form-control" name="email" type="text" readonly value="${user.email}" >
					<div class="invalid-feedback" id="errorEmail"></div>

					</div>

				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="pawssword-input-field">Contrase�a</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputPassword" class="form-control" name="pass" type="password" value="${user.pass}">
					<div class="invalid-feedback" id="errorPassword"></div>

					</div>

				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Nick</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputNick" class="form-control" name="nick" type="text" value="${user.nick}">
					<div class="invalid-feedback" id="errorNick"></div>

					</div>

				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Nombre</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputName" class="form-control" name="first_name" type="text" value="${user.first_name}">
					<div class="invalid-feedback" id="errorName"></div>

					</div>

				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Apellidos</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputLastName" class="form-control" name="last_name" value="${user.last_name}">
					<div class="invalid-feedback" id="errorLastName"></div>

					</div>

				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Fecha
							nacimiento</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputDate" class="form-control" name="b_date" type="text" placeholder="DD/MM/YYYY" value="${user.b_date}">
					<div class="invalid-feedback" id="errorDate"></div>

					</div>

				</div>

				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Pais
							de residencia</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputCountry" class="form-control" name="country" type="text" value="${user.country}">
					<div class="invalid-feedback" id="errorCountry"></div>

					</div>

				</div>
				
				<div class="form-row form-group">
					<div class="col-sm-4 text-center label-column">
						<label class="col-form-label" for="name-input-field">Capital</label>
					</div>
					<div class="col-sm-6 input-column">
						<input id="inputCapital" class="form-control" readonly name="capital" type="text" value="${user.fondos}">
					<div class="invalid-feedback" id="errorCapital"></div>

					</div>

				</div>

				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="formCheck-1"><label
						class="form-check-label" for="formCheck-1">He leido, y acepto la politica de privacidad</label>
				</div>
				<button id="submit" class="btn btn-light submit-button" type="submit"
					style="background: #ffdf08; height: 47px; color: rgb(0, 0, 0); border-radius: 5px;">Enviar</button>
			</form>
		</div>
	</div>
	<footer class="footer-dark" style="background: #2a076e;">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-3 item">
					<h3 style="color: #ffffff;">Servicios</h3>
					<ul>
						<li><a href="#">Web design</a></li>
						<li><a href="#">Development</a></li>
						<li><a href="#">Hosting</a></li>
					</ul>
				</div>
				<div class="col-sm-6 col-md-3 item">
					<h3 style="color: #ffffff;">About</h3>
					<ul>
						<li><a href="#" style="color: rgb(240, 249, 255);">Company</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Careers</a></li>
					</ul>
				</div>
				<div class="col-md-6 item text">
					<h3 style="color: #ffffff;">
						<i class="fa fa-rocket"></i>&nbsp;CriCoin
					</h3>
					<p>Praesent sed lobortis mi. Suspendisse vel placerat ligula.
						Vivamus ac sem lacus. Ut vehicula rhoncus elementum. Etiam quis
						tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel
						in justo.</p>
				</div>
				<div class="col item social">
					<a href="#" style="color: #ffdf08;"><i
						class="icon ion-social-facebook"></i></a><a href="#"
						style="color: #ffdf08;"><i class="icon ion-social-twitter"></i></a><a
						href="#" style="color: #ffdf08;"><i
						class="icon ion-social-snapchat"></i></a><a href="#"
						style="color: #ffdf08;"><i class="icon ion-social-instagram"></i></a>
				</div>
			</div>
			<p class="copyright">
				<i class="fa fa-rocket"></i>&nbsp;CriCoin © 2021
			</p>
		</div>
	</footer>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bs-init.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.6.0/umd/popper.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.flash.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.html5.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.print.min.js"></script>
	<script src="assets/js/Bootstrap-DataTables.js"></script>
	<script src="assets/js/DataTable---Fully-BSS-Editable.js"></script>
	<script src="assets/js/editProfile.js"></script>
</body>

</html>
<%}else{ response.sendRedirect("index.jsp");}%>