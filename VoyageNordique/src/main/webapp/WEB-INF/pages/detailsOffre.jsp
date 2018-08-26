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
	<div class="container marketing">
		<h1 style="margin-left: 25px">Détails de l'offre</h1>
		<div class="row featurette"
			style="margin: 25px; border: 2px solid black; padding: 5px; margin-right: none">
			<div class="col-md-7">
				<h2 class="featurette-heading">${ovDetails.designation}</h2>
				<h2>${o.pays},
					à <span class="text-muted">${ovDetails.ville}</span>
				</h2>
				<p class="lead">${ovDetails.descriptionVoyage}</p>
				<h2>Détails du vol</h2>
				<p class="lead">${ovDetails.compagnieAerienne}</p>
				<label>Date de Départ</label>
				<p>
					<fmt:formatDate value="${ovDetails.dateDepart}"
						pattern="dd/MM/yyyy" />
				</p>
				<label>Date de Retour</label>
				<p>
					<fmt:formatDate value="${ovDetails.dateRetour}"
						pattern="dd/MM/yyyy" />
				</p>
				<div
					style="border: 2px solid #4172c1; margin-bottom: 5px; padding-top: 5px; text-align: center; background-color: #4172c1">
					<p style="font-size: larger; color: white">${ovDetails.prixVoyage}
						&#8364</p>
				</div>
				<a class="btn btn-lg btn-info" href="#" role="button"
					style="margin: 6px;">Réserver</a>

			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${ovDetails.idVoyage}"
					alt="Generic placeholder image"
					style="width: 250px; height: 250px; border: 1px solid black; margin-top: 100px; padding: none">
			</div>
		</div>

		<hr class="featurette-divider">

		<h1 style="margin-left: 25px">Détails de l'hébergement</h1>
		<div class="row featurette"
			style="margin: 25px; border: 2px solid black; padding: 5px; margin-right: none">
			<div class="col-md-7">
				<h2 class="featurette-heading">${hebDetails.nomHebergement}</h2>
				<p class="lead">${hebDetails.descriptionHebergement}</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src="${pageContext.request.contextPath}/hebergement/getImage?pId=${hebDetails.idHebergement}"
					alt="Generic placeholder image"
					style="width: 250px; height: 250px; border: 1px solid black; margin-top: 100px; margin-bottom: 5px; padding: none">
			</div>
		</div>

		<hr class="featurette-divider">
		<h1 style="margin-left: 25px">Véhicules disponibles</h1>
		<div class="row featurette"
			style="margin: 25px; border: 2px solid black; padding: 5px; margin-right: none">

			<div class="col-md-7" style="text-align: center">
				<h2>${vDetails.categorieVehicule}</h2>
				<h2>${vDetails.marqueVehicule}</h2>
				<div
					style="border: 2px solid #4172c1; margin-bottom: 5px; padding-top: 5px; text-align: center; background-color: #4172c1">
					<p style="color: white">Prix: ${vDetail.prixVehicule} &#8364</p>
				</div>
				<a class="btn btn-lg btn-info" href="" role="button"
					style="margin: 6px;">Réserver un véhicule</a>
			</div>
		</div>
		<hr class="featurette-divider">
		<h1 style="margin-left: 25px">Excursions disponibles</h1>
		<div class="row">
			<c:forEach var="ex" items="${exListe}">
				<div class="col-lg-4" style="text-align: center">
					<img class="img-circle"
						src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${ex.idExcursion}"
						alt="Generic placeholder image" width="140" height="140">
					<h2>${ex.nomExcursion}</h2>
					<p>${ex.descriptionExcursion}</p>
					<div
						style="border: 2px solid #4172c1; margin-bottom: 5px; padding-top: 5px; text-align: center; background-color: #4172c1">
						<p style="color: white">Prix: ${ex.prixExcursion} &#8364</p>
					</div>
					<a class="btn btn-lg btn-info" href="" role="button"
						style="margin: 6px;">Réserver une excursion</a>
				</div>
			</c:forEach>

		</div>
		<!-- /.container -->
</body>
</html>