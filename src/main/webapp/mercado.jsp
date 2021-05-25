<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.criCoinWeb.*" %>
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
<link rel="stylesheet" href="assets/css/mercado.css">


</head>

<body>

<!-------------------------------aqui empieza navbar------------------------------>
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
					<li class="nav-item"></li>
					<li class="nav-item"><a class="nav-link" href="academia.jsp">Academia</a></li>
					<li class="nav-item"><a class="nav-link" href="./controller?accion=ranking">Ranking</a></li>
					<li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
					<li class="nav-item"></li>
					<li class="nav-item"><a class="nav-link" href="./controller?accion=recuperarDatosCartera">Cartera</a></li>
					<li class="nav-item">
						<a class="nav-link" href="editProfile.jsp">Perfil&nbsp;
							<i class="fa fa-user" style="color: #2a076e;"></i>
						</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-bell" style="color: #2a076e;"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="#">EUR</a></li>
				</ul>
			</div>
		</div>
	</nav>
<!---------------------------------------fin navbar---------------------------------->
<div class="container-fluid">
<!-------------------------------mensaje bienvendida------------------------------>
	<h1 style="text-align: center; font-size: 33px; padding: 34px; font-weight: bolder;">MERCADO</h1>
	<%
	if (session.getAttribute("user") != "") {
	%>
	<h2 class="mercado-bienvenido">
		Bienvenido 
		<c:out value="${user.nick}" />
	</h2>
	<%
	}
	%>
<!--------///////////////////////////////fin mensaje bienvendida//////////////////////////////////---------->	

<!-----------------------------------------------------------bloque mercado-------------------------------------------------------------->	
	
<!--------------------------------------------iframe gr�fica --------------------------------- -->
		<div class="row">
		<div class="col-md-9"> <!-- extra1 -->
		<div style="height: 560px; background-color: #FFFFFF; overflow: hidden; box-sizing: border-box; border: 0px solid #56667F; border-radius: 4px; text-align: right; line-height: 14px; font-size: 12px; font-feature-settings: normal; text-size-adjust: 100%;  padding: 1px; padding: 0px; margin: 0px; width: 100%;">
			<div style="height: 540px; padding: 0px; margin: 0px; width: 100%;">
				<iframe id="grafico"
					src="https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=859&pref_coin_id=1505"
					width="100%" height="536px" scrolling="auto" marginwidth="0"
					marginheight="0" frameborder="0" border="0"
					style="border: 0; margin: 0; padding: 0; line-height: 14px;"></iframe>
			</div>
		</div>
		</div><!-- extra1 -->
<!-- /////////////////fin iframe grafica//////////////////////////// -->

<!---------------------------inicio compra/venta -------------------------- -->
		<div class="col-md-3"><!-- extra2 -->
		<div class="mercbox pb-3" style="background-color: #FFDF08">
			<!-- ricardo -->
			<!-- Nav tabs -->
			<ul class="nav nav-tabs justify-content-center nav-fill"  >
				<li class="nav-item" ><a class="nav-link active" 
					data-toggle="tab" href="#compra">Comprar</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#venta">Vender</a></li>

			</ul>
			<!-- Tab panes -->
			<div class="tab-content" >
			<!-- aqui empieza compraCompra -->
				<div class="tab-pane container active" id="compra" >
				<div class="mt-5" >
				<form action="./controller?accion=comprar" method="post" name="myForm" id="idMyform" onsubmit="return validateValorCompra()" style="margin-bottom: 10px; text-align: left; margin-top: 10px;">
					<div class="input-group mb-3">
  					<div class="input-group-prepend">
    				<label class="input-group-text" for="inputGroupSelect01">PAR</label>
  					</div>
  			
  					<select class="custom-select" id="inputGroupSelect01" name='selCoin'>
    						<option selected id="859">Elige tu moneda...</option>  
							<option id="859" value="bitcoin" >BTC</option>
							<option id="145" value="ethereum">ETH</option>
							<option id="1209" value="binancecoin">BNB</option>
							<option id="122882" value="cardano">ADA</option>
							<option id="359" value="litecoin">LTC</option>
 						</select>
 				
					</div>
					
					
					<label>Cantidad de compra:&nbsp;</label>
					
					<input class="form-control" id="conversion" name="conversion" readonly type="number" value="0">
					
					<div class="mb-4"><span id="cartera">Valor COIN</span></div>
					
					<label>Valor de compra:&nbsp;</label>
				
					<input class="form-control" id="apuesta" name="apuesta"  type="number" value=" " placeholder="Introduce la cantidad...">

					<div class="mb-4"><span id="sonante" ><c:out value="${user.capital}" /></span> USD<span id="sonanteIni" style="display:none"><c:out value="${user.capital}" /></span></div><!-- aqui va la cantidad de dolares que tengo -->
					
					<div class="mt-2"><button type="submit" class="btn  btn-block mt-2 comVen">Comprar</button></div>
					</form>
					
				</div>
				</div>
			<!---------- fin compra ------------>
			<!-- aqui empieza contenido venta -->
			
				<div class="tab-pane container fade" id="venta">
				<div class="mt-5" >
				<form action="./controller?accion=vender" method="post" name="myFormVenta" id="idMyformVenta" onsubmit="return validateValorVenta()" style="margin-bottom: 10px; text-align: left; margin-top: 10px;">
					<div class="input-group mb-3">
  						<div class="input-group-prepend">
    						<label class="input-group-text" for="inputGroupSelect02">PAR</label>
  						</div>
  			
  						<select class="custom-select" id="inputGroupSelect02" name='buyCoin'>
    						<option selected id="859">Elige tu moneda...</option>  
							<option id="859" value="bitcoin" >BTC</option>
							<option id="145" value="ethereum">ETH</option>
							<option id="1209" value="binancecoin">BNB</option>
							<option id="122882" value="cardano">ADA</option>
							<option id="359" value="litecoin">LTC</option>
 						</select>
 				
					</div>
					
					
						<label>Valor de venta:&nbsp;</label>
					
						<input class="form-control" id="conversionVenta" name="conversionVenta" readonly type="number" value="0"><!-- aqui va lo que ganare en dolares con la venta por la cantidad de coin que pongo abajo -->
					
						<div class="mb-4"><span id="precioCoin" />Valor COIN</span></div><!-- aqui va el precio del dolar contra la moneda -->
						
		
						<label>Cantidad de venta:&nbsp;</label>
						
						<input class="form-control" id="apuestaVenta" name="apuestaVenta"  type="number" value=" " placeholder="Introduce la cantidad..."><!-- aqui elijo cuanta coin quiero vender "apuesta" en caso compra -->
						
						<div class="mb-4"><span id="carteraVenta" ></span><span id="coinVenta" >COINs en haber</span></div><!-- aqui va la cantidad de la moneda seleccionada que tengo -->
						
					
						<div class="mt-2"><button type="submit" class="btn  btn-block mt-2 comVen">Vender</button></div>
					</form>
				</div>

				</div>

			</div>
			<!-- fin ricardo-->
			
		</div>
		</div><!-- extra2 -->
		</div>
<!-- ////////////////////////////fin compra/venta/////////////////////////////////// -->

<!--------------------------------precios mercado ---------------------------- -->
		<div class="row">
		<div class="col-md-10">
			<div class="mercado-coin-list"
				style="height: 433px; background-color: #FFFFFF; overflow: hidden; box-sizing: border-box; border: 1px solid #56667F; border-radius: 4px; text-align: right; line-height: 14px; font-size: 12px; font-feature-settings: normal; text-size-adjust: 100%; box-shadow: inset 0 -20px 0 0 #56667F; padding: 0px; margin: 0px; width: 100%;">
				<div style="height: 413px; padding: 0px; margin: 0px; width: 100%;">
					<iframe
						src="https://widget.coinlib.io/widget?type=full_v2&theme=light&cnt=6&pref_coin_id=1505&graph=yes"
						width="100%" height="409px" scrolling="auto" marginwidth="0"
						marginheight="0" frameborder="0" border="0"
						style="border: 0; margin: 0; padding: 0;"></iframe>
				</div>
			</div>
		</div>
<!---------///////////////////////////fin precios mercado //////////////////////////////-------- -->

<!-------------------------------------cambio ----------------------------- -->
			<div class="col-md-2">
				<div class="mercado-coin-conversor "
					style=" height: 433px; background-color: #FFFFFF; overflow: hidden; box-sizing: border-box; border: 1px solid #56667F; border-radius: 4px; text-align: right; line-height: 14px;  font-size: 12px; font-feature-settings: normal; text-size-adjust: 100%; box-shadow: inset 0 -20px 0 0 #56667F; margin: 0; width: 100%; padding: 1px; padding: 0px; margin: 0px;">
					<div><h4 class="text-center font-weight-bold  mt-1">Cambios</h4></div>
					<div style="height: 413px; padding: 0px; margin: 0px; width: 100%;">
						<iframe
							src="https://widget.coinlib.io/widget?type=converter&theme=light"
							width="100%" height="310px" scrolling="auto" marginwidth="0"
							marginheight="0" frameborder="0" border="0"
							style="border: 0; margin: 0; padding: 0;"></iframe>
					</div>
				</div>
				
				</div>
			
			</div>
<!-- //////////////////////////////////fin cambio/////////////////////////// -->
		</div>
	
<!----------------------------------------------------------------------fin bloque mercado------------------------------------------------------------>
	</div>
	<div class="mt-5"
		style="height: 52px; background-color: #FFFFFF; overflow: hidden; box-sizing: border-box; border: 1px solid #56667F; border-radius: 0px; text-align: right; line-height: 14px; block-size: 48px; font-size: 12px; font-feature-settings: normal; text-size-adjust: 100%;  padding: 1px; padding: 0px; margin: 0px; width: 100%;">
		<div style="height: 40px; padding: 0px; margin: 0px; width: 100%;">
			<iframe
				src="https://widget.coinlib.io/widget?type=horizontal_v2&theme=light&pref_coin_id=1505&invert_hover="
				width="100%" height="36px" scrolling="auto" marginwidth="0"
				marginheight="0" frameborder="0" border="0"
				style="border: 0; margin: 0; padding: 0;"></iframe>
		</div>
		<!--  <div
			style="color: #FFFFFF; line-height: 14px; font-weight: 400; font-size: 11px; box-sizing: border-box; padding: 2px 6px; width: 100%; font-family: Verdana, Tahoma, Arial, sans-serif;">
			<a href="https://coinlib.io" target="_blank"
				style="font-weight: 500; color: #FFFFFF; text-decoration: none; font-size: 11px">Cryptocurrency
				Prices</a>&nbsp;by Coinlib
		</div>-->
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
				<i class="fa fa-rocket"></i>&nbsp;CriCoin 2021
			</p>
		</div>
	</footer>
	<script type="text/javascript">

	let monedas = <% 
	
	System.out.println("User: "+session.getAttribute("user"));
	UserPojo user = (UserPojo)session.getAttribute("user"); //declaro el userpojo habiendodo importado arriba @ page import="com.criCoinWeb.*" 
	out.print("[");
	//for (WalletPojo wp: user.getCartera()){
		for (int i=0;i<user.getCartera().size();i++){ //recorro para sacar los valores
			
		WalletPojo wp = user.getCartera().get(i);
		out.print("['"+wp.getMoneda().getName()+"',"+wp.getTotal_coin()+"]");
		
		if (i<user.getCartera().size()-1){
			out.println(",");
		}
		//out.print("["+);
		
	}
	out.print("];");
	
	%>
	
	
	function valorCoin(coinName){ //funcion para usar luego en js
		
		for (var i=0; i<monedas.length;i++){ //recorro el array para sacar el valor de la moneda que le meto por parametro
		if (monedas[i][0] == coinName){
			return monedas[i][1];	
		}
		
		}
		
		
	
	}
	
	

	</script>
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
	<script src="assets/js/mercado.js"></script>
	
</body>

</html>