<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajouter la lib bootstrapp.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<title>Ligne Commande Page</title>
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
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>
	</form:form>
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

	<h1 style="color: blue">${msg}</h1>
</body>
</html>