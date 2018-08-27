<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8">

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">

<!-- ci-dessous notre fichier CSS -->
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
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="main">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-sm-offset-1">
							<h1 style="color : #000099">BiFrost Voyage</h1>
							<br/>
							<h2>Réserver pour explorer</h2>
							<form action="j_spring_security_check" method="post"
								accept-charset="utf-8">
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" name="j_username" class="form-control"
											placeholder="Email/Idenfiant" />
									</div>
								</div>
								<br/>
								<br/>
								<div class="form-group">
									<div class="col-md-8">
										<input type="password" name="j_password"
											placeholder="Mot de passe" class="form-control" />
									</div>
								</div>
<br/>
								<br />
								<div class="form-group">
									<div class="col-md-offset-0 col-md-8">
										<input class="btn btn-primary" type="submit"
											value="Se Connecter" />
									</div>
								</div>

							</form>
							<p class="credits">
								<a
									href="${pageContext.request.contextPath}/client/ajouterClient"
									style="color: #4172c1;; background-color: #ffffff">Pas
									encore inscrit? Créez un compte!</a>
							</p>
						</div>
						<div class="">
							<img alt=""
								src="${pageContext.request.contextPath}/images/drakkar-viking.jpg">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty echec}">
		<h1 style="color: red; text-align: center">Le mot de passe ou le
			login est erroné.</h1>
	</c:if>
	<c:if test="${not empty msg}">
		<h1 style="color: red; text-align: center">Vous êtes déconnecté.</h1>
	</c:if>
</body>
</html>