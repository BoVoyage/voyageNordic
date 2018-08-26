<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Carousel Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="style.css" rel="stylesheet">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}/offreVoyage/listeOffreVoyage">Bifrost
							Voyage</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="${pageContext.request.contextPath}/offreVoyage/listeOffreVoyage">Promos!</a></li>
							<li><a href="${pageContext.request.contextPath}/">Login</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Cherchez et réservez!<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a
										href="${pageContext.request.contextPath}/offreVoyage/listeOffreVoyage">Toutes
											nos offres</a></li>
									<li><a
										href="${pageContext.request.contextPath}/offreVoyage/rechercherParNoVoyage">Rechercher
											une offre</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="../resources/images/VoyageNordicLogo.png"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Example headline.</h1>
					</div>
				</div>
			</div>
			<c:forEach var="o" items="${allOffresVoyage}">
				<div class="item">
					<img class="slide"
						src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${o.idVoyage}"
						alt="Slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>${o.ville}</h1>
							<h2>${o.pays}</h2>
							<p>${o.descriptionVoyage}</p>
							<p>
								<s>${o.prixVoyage}</s>
							</p>
							<h3 style="color: red">${o.remiseVoyage}&euro</h3>
							<p>
								<a class="btn btn-lg btn-info" href="#" role="button">Réserver</a>
							</p>
						</div>
					</div>
			</c:forEach>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->


		<!-- Marketing messaging and featurettes
    ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">

			<!-- Three columns of text below the carousel -->
			<c:forEach var="o" items="${allOffresVoyage}">
				<div class="row">
					<div class="col-lg-4">
						<img class="img-circle"
							src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${o.idVoyage}"
							alt="Generic placeholder image" width="140" height="140">
						<h1>${o.ville}</h1>
						<h2>${o.pays}</h2>
						<p>${o.descriptionVoyage}</p>
						<p>
							<s>${o.prixVoyage}</s>
						</p>
						<p>
							<a class="btn btn-lg btn-info" href="#" role="button">Réserver</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
				</div>
				<!-- /.row -->
			</c:forEach>
</body>
</html>
