<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de modification d'un Véhicule</title>

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
		action="soumettreModifVehicule" modelAttribute="vehiculeModif">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idVehicule">ID du Véhicule</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="idVehicule"
					path="idVehicule" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="categorieVehicule">Catégorie du véhicule</form:label>
			<div class="col-sm-9">
				<select class=form-control name="categorieVehicule">
					<option value="4x4">4x4</option>
					<option value="Familiale">Familiale</option>
					<option value="Berline">Berline</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="marqueVehicule">Marque du Véhicule</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="marqueVehicule"
					path="marqueVehicule" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixVehicule">Prix TTC</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prixVehicule"
					path="prixVehicule" />
			</div>
		</div>

		<button type="submit" class="btn btn-default">Modifier ce
			véhicule</button>
	</form:form>


	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Une erreur est survenue lors de la modification du véhicule !</h1>
	</c:if>

</body>
</html>