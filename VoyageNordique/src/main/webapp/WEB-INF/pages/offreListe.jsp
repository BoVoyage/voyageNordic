<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>Heimdall Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

<!-- Insérer un slideshow avec les offres du moment, un résumé et un lien vers les détails -->
<!-- Insérer un filtre permettant de filtrer les offres. -->
<!-- Insérer une liste complète des offres sur 2 colonnes responsives -->

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

		<c:forEach var="o" items="${allOffresVoyage}">
			<tr>
				<td>${o.noVoyage}</td>
				<td>${o.designation}</td>
				<td>${o.pays}</td>
				<td>${o.ville}</td>
				<td>${o.descriptionVoyage}</td>
				<td>${o.prixVoyage}</td>
				
				<td><img  src="${pageContext.request.contextPath}/offreVoyage/getImage?pId=${o.idVoyage}" style="width: 100px; height: 100px"/></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>