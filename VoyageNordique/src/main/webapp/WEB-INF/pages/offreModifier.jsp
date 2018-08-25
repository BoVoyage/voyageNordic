<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de modification d'une offre</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifOffre" modelAttribute="offreModif"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9" id="listeNo">
				<select id="noVoyage">
				<option id="noVoyage" value="noVoyage" >${listingNoVoyage.noVoyage}</option>
				</select>
					
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="designation">Nom du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="designation"
					path="designation" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="pays" path="pays" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="ville">Ville</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="ville" path="ville" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="descriptionVoyage">Description du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="descriptionVoyage"
					path="descriptionVoyage" />
			</div>
		</div>
		<div class="radio">
			<form:label cssClass="col-sm-3 control-label" path="etat">
				<input type="radio" name="etat" value="true">
				Offre valide
			</form:label>
			<form:label cssClass="col-sm-3 control-label" path="etat">
				<input type="radio" name="etat" value="false">
				Offre close
			</form:label>
		</div>
		<br />
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="quantite">Quantite</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="quantite"
					path="quantite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixVoyage">Prix initial du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prixVoyage"
					path="prixVoyage" />
			</div>
		</div>
		<div class="radio">
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="true"> Voyage en promotion
			</form:label>
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="false" />
				Voyage non remisé
			</form:label>
		</div>
		<br />
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="remiseVoyage">Prix remisé du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="remiseVoyage"
					path="remiseVoyage" />
			</div>
		</div>

		<input style="margin: auto" type="file" name="file" />

		<button type="submit" class="btn btn-default">Modifier cette
			offre de voyage</button>
	</form:form>


	<h1 style="color: red; text-align: center">${error}</h1>

</body>
</html>