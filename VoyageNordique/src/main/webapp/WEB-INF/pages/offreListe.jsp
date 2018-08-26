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
<title>Heimdall Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<!-- Insérer un slideshow avec les offres du moment, un résumé et un lien vers les détails -->
	<!-- Insérer un filtre permettant de filtrer les offres. -->
	<!-- Insérer une liste complète des offres sur 2 colonnes responsives -->

	<div class="container marketing">

		<div class="row">
			<c:forEach var="o" items="${allOffresPromo}">
				<div class="col-lg-4" style="text-align: center">
					<img class="img-circle"
						src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${o.idVoyage}"
						alt="Generic placeholder image" width="140" height="140">
					<h2>${o.designation}</h2>
					<h2>${o.pays},
						à <span class="text-muted">${o.ville}</span>
					</h2>
					<div
						style="border: 2px solid #4172c1; margin-bottom: 5px; padding-top: 5px; text-align: center; background-color: #4172c1">
						<s><p style="color: white"> Prix initial: ${o.prixVoyage}
							&#8364</p></s>
							<p style="font-size: larger; color: white"> PROMO!: ${o.remiseVoyage}
							&#8364</p>
					</div>
						<a class="btn btn-default" href="#" role="button">View details
							&raquo;</a>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

		<c:forEach var="o" items="${allOffresVoyage}">
			<div class="row featurette"
				style="margin: 25px; border: 2px solid black; padding: 5px; margin-right: none">
				<div class="col-md-7">
					<h2 class="featurette-heading">${o.designation}</h2>
					<h2>${o.pays},
						à <span class="text-muted">${o.ville}</span>
					</h2>
					<p class="lead">${o.descriptionVoyage}</p>
					<div
						style="border: 2px solid #4172c1; margin-bottom: 5px; padding-top: 5px; text-align: center; background-color: #4172c1">
						<p style="font-size: larger; color: white">${o.prixVoyage}
							&#8364</p>
					</div>
					<a class="btn btn-lg btn-info" href="#" role="button"
						style="margin: 6px;">Réserver</a>

				</div>
				<div class="col-md-5">
					<img class="featurette-image img-responsive center-block"
						src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${o.idVoyage}"
						alt="Generic placeholder image"
						style="width: 250px; height: 250px; border: 1px solid black; margin: none; padding: none">
				</div>
			</div>

			<hr class="featurette-divider">
		</c:forEach>
	</div>
	<!-- /.container -->
</body>
</html>