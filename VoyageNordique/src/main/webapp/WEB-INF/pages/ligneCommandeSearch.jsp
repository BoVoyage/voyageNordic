<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
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

	<form:form cssClass="form-horizontal" metho="POST"
		action="soumettreSearchLigneCommandebyCommande"
		modelAttribute="lcSearch2">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="${lc.commande.noCommande}">Numéro de commande</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="numero de commande"
					path="${lc.commande.noCommande}" />
			</div>
			<form:label cssClass="col-sm-2 control-label"
				path="${lc.idLigneCommande}">Id Ligne de commande</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id ligne de commande"
					path="${lc.idLigneCommande}" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>
	</form:form>

	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Cette commande
			n'existe pas (vérifiez votre n° de commande)</h1>
	</c:if>

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
					href="<c:url value="/lignecommande/deleteLCLink?pId=${lc.idLigneCommande}"/>">
						supprimer </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>