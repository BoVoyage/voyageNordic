<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de recherche Client</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"	action="soumettreRechercheClient" modelAttribute="clientRecherche">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noClient">N° référence du Client</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noClient"	path="noClient" />
			</div>
		</div>	
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nomClient">Nom Client</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="nomClient"	path="nomClient" />
			</div>
		</div>
		<button type="submit" class="btn btn-default">Rechercher Client</button>
	</form:form>

	<table class="table table-bordered">
		<tr>
			<th>Numéro Client</th>
			<th>Nom Client</th>
			<th>Prenom Client</th>
			<th>Date de Naissance</th>
			<th>Mail</th>
			<th>Mot de passe</th>
			<th>Telephone</th>
		</tr>
		<c:forEach var="cl" items="${clientListe}">
			<tr>
				<td>${cl.noClient}</td>
				<td>${cl.nomClient}</td>
				<td>${cl.prenomClient}</td>
				<td>${cl.dn}</td>
				<td>${cl.mail}</td>
				<td>${cl.mdp}</td>
				<td>${cl.tel}</td>
			</tr>
		</c:forEach>
	</table>
	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>