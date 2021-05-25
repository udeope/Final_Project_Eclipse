<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%if((session.getAttribute("user"))==null){ %><!-- la comparacion es null antes y equals -->


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Proyecto_final</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="assets/css/Header-Blue.css">
    <link rel="stylesheet" href="assets/css/Header-Dark.css">
    <link rel="stylesheet" href="assets/css/Highlight-Phone.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Button.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    
</head>
<body>
    <nav class="navbar navbar-light navbar-expand-md sticky-top navigation-clean-button" data-aos="fade" style="filter: blur(0px);opacity: 0.90;">
        <div class="container-fluid"><a class="navbar-brand" href="index.jsp"><img src="assets/img/Main%20logo.png" style="width: 149px;margin: 9px;"></a><button class="navbar-toggler" data-toggle="collapse"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button></div>
    </nav>
    <section class="login-clean">
        <form action="./controller?accion=login" method="post" onsubmit="return loginValidate()" id="login"  name="log">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="fas fa-rocket" style="color: #5319c3;"></i></div>
            <div class="form-group"><input class="form-control" type="text" name="emailLogin" id="inputEmail" placeholder="Email"><div class="invalid-feedback" id="errorEmail"></div>
        </div>
            <div class="form-group"><input id="inputPassword" class="form-control" type="password" name="password" placeholder="Password"><div class="invalid-feedback" id="errorPassword"></div>
        </div>
            <div class="form-group"><button id="submit" class="btn btn-primary btn-block" type="submit" style="background: #ffdf08;color: rgb(0,0,0);">Iniciar Sesión</button></div><a class="forgot" href="#">¿Has olvidado tu contraseña?</a>
        </form>
    </section>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.3.4/aos.js"></script>
    <script src="assets/js/login.js"></script>
</body>
</html>

<%}else{ response.sendRedirect("index.jsp");}%>

