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