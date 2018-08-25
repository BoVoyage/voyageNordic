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

<title>Ligne Commande Page</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<table class="table table-bordered">



		<tr>
			<th>Numéro Commande</th>
			<th>Nb de place</th>
			<th>Prix</th>
			<th>Gestion</th>

		</tr>

		<c:forEach var="lc" items="${listeLC}">
			<tr>
				<td>${lc.commande.noCommande}</td>
				<td>${lc.quantite}</td>
				<td>${lc.prix}</td>
				<td><a
					href="<c:url value="/lignecommande/updateLCLink?pId=${lc.idLigneCommande}"/>">
						modifier </a>| <a
					href="<c:url value="/lignecommande/deleteLCLink/${lc.idLigneCommande}"/>">
						supprimer </a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>