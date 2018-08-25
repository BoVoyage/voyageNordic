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

	<!-- Ins�rer un slideshow avec les offres du moment, un r�sum� et un lien vers les d�tails -->
	<!-- Ins�rer un filtre permettant de filtrer les offres. -->
	<!-- Ins�rer une liste compl�te des offres sur 2 colonnes responsives -->

	<table class="table table-bordered">
		<tr>
			<th>Nom H�bergement</th>
			<th>Description</th>
			<th>Image</th>
			<th>Gestion</th>
		</tr>

		<c:forEach var="h" items="${allHebergements}">
			<tr>
				<td>${h.nomHebergement}</td>
				<td>${h.descriptionHebergement}</td>
				<td><img
					src="${pageContext.request.contextPath}/hebergement/getImage?pId=${h.idHebergement}"
					style="width: 100px; height: 100px" /></td>
				<td><a
					href="${pageContext.request.contextPath}/hebergement/modifLinkHeb?pNom=${h.nomHebergement}">Modifier</a>
					|<a
					href="<c:url value="/hebergement/supprHebLink/${h.nomHebergement}"/>">Supprimer</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>