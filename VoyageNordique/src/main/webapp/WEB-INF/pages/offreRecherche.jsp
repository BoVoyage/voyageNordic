<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de recherche d'une offre de voyage</title>

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

</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreSearch" modelAttribute="SearchNoVoyage">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noVoyage"
					path="noVoyage" />
			</div>
		</div>
		<button type="submit" class="btn btn-default">Rechercher
			l'offre de voyage</button>
	</form:form>

	<table class="table table-bordered">
		<tr>
			<th>Numéro Offre</th>
			<th>Nom Offre</th>
			<th>Pays</th>
			<th>Ville</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Date de départ</th>
			<th>Date de retour</th>
			<th>Compagnie aérienne</th>
			<th>Image</th>
		</tr>


		<tr>
			<td>${SearchNoVoyage.noVoyage}</td>
			<td>${SearchNoVoyage.designation}</td>
			<td>${SearchNoVoyage.pays}</td>
			<td>${SearchNoVoyage.ville}</td>
			<td>${SearchNoVoyage.descriptionVoyage}</td>
			<td>${SearchNoVoyage.prixVoyage}</td>
			<td>${SearchNoVoyage.dateDepart}</td>
			<td>${SearchNoVoyage.dateRetour}</td>
			<td>${SearchNoVoyage.compagnieAerienne}</td>

			<td><img
				src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${SearchNoVoyage.idVoyage}"></td>
		</tr>


	</table>

	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Aucune offre de voyage ne correspond à ce numéro !</h1>
	</c:if>
	
</body>
</html>