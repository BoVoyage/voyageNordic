<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de recherche d'une offre de voyage</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

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
			<th>Image</th>
		</tr>


		<tr>
			<td>${SearchNoVoyage.noVoyage}</td>
			<td>${SearchNoVoyage.designation}</td>
			<td>${SearchNoVoyage.pays}</td>
			<td>${SearchNoVoyage.ville}</td>
			<td>${SearchNoVoyage.descriptionVoyage}</td>
			<td>${SearchNoVoyage.prixVoyage}</td>

			<td><img
				src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${SearchNoVoyage.idVoyage}"></td>
		</tr>


	</table>


	<h1 style="color: red; text-align: center">${error}</h1>

</body>
</html>