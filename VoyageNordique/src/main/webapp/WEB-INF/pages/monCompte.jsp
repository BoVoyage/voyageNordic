<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ajouter la librairie de bootstrap.css -->
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
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<h1 style="margin-left: 25px">Mes informations</h1>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<p>Nom</p>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<p>${clientIn.nomClient}</p>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-2">
				<p>Prenom</p>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<p>${clientIn.prenomClient}</p>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-1">
				<p>Date de naissance</p>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<p>
					<fmt:formatDate value="${clientIn.dn}" pattern="dd/MM/yyyy" />
				</p>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-2">
				<p>Mail</p>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<p>${clientIn.mail}</p>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-2">
				<p>Mot de passe</p>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<p>${clientIn.mdp}</p>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-2">
				<p>Téléphone</p>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<p>${clientIn.tel}</p>
			</div>

		</div>
	</div>

	<a class="btn btn-lg btn-info" href="${pageContext.request.contextPath}/client/modifLinkClient?pMail=${clientIn.mail}" role="button"
		style="margin: 6px;">Modifier mes informations</a>

	<br />
	
	<a class="btn btn-lg btn-info" href="${pageContext.request.contextPath}/client/clientLoggedIn/supprimer" role="button"
		style="margin: 6px;">Supprimer mon compte</a>
</body>
</html>