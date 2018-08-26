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
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>

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
	<%@ include file="../../templates/headerBack.html"%>

	<br />

	<!-- ********************************************************************************************** -->
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" style="color: white; margin-left: 40%; margin-right: 30%"">
		<b>Rechercher Client</b>
	</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title" id="exampleModalLabel"
						style="color: blue; text-align: center">
						<b>Rechercher Client</b>
					</h1>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- ********$$$$$$$$$$$$$$*************** -->

					<form:form cssClass="form-horizontal" method="POST"
						action="soumettreRechercheClient" modelAttribute="clientRecherche">
						<div class="form-group">
							<form:label cssClass="col-sm-2 control-label" path="noClient"
								cssStyle="color: blue">N° référence Client</form:label>
							<div class="col-sm-9">
								<form:input cssClass="form-control" placeholder="noClient"
									path="noClient" />
							</div>
						</div>
						<div class="form-group">
							<form:label cssClass="col-sm-2 control-label" path="nomClient"
								cssStyle="color: blue">Nom Client</form:label>
							<div class="col-sm-9">
								<form:input cssClass="form-control" placeholder="nomClient"
									path="nomClient" />
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Rechercher
							Client</button>
					</form:form>

					<!-- ********$$$$$$$$$$$$$$*************** -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Annuler
						Recherche Client</button>

				</div>
			</div>
		</div>
	</div>
<c:if test="${not empty cl}">
	<table class="table table-bordered">
		<tr>
			<th style="color: blue; text-align: center">Numéro Client</th>
			<th style="color: blue; text-align: center">Nom Client</th>
			<th style="color: blue; text-align: center">Prenom Client</th>
			<th style="color: blue; text-align: center">Date de Naissance</th>
			<th style="color: blue; text-align: center">Mail</th>
			<th style="color: blue; text-align: center">Mot de passe</th>
			<th style="color: blue; text-align: center">Telephone</th>
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
	</c:if>
	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Aucun client n'existe sous cet identifiant !</h1>
	</c:if>

</body>
</html>