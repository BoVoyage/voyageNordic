<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'ajout Offre de Voyage</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<body>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutOffre" modelAttribute="offreAjout" enctype = "multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noVoyage"
					path="noVoyage" />
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
			<form:label cssClass="col-sm-2 control-label" path="quantite">Quantite</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="quantite"
					path="quantite" />
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
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixVoyage">Prix initial du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prixVoyage"
					path="prixVoyage" />
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
			<div class="checkbox">
				<form:label path="etat"><form:input type="radio" value="true" path="etat"/> Offre valide</form:label>
			</div>
			<div class="checkbox">
				<form:label path="etat"><form:input type="radio" value="false" path="etat"/> Offre close</form:label>
			</div>
		</div>
		<div class="form-group">
			<div class="checkbox">
				<form:label path="promotion"><form:input type="radio" value="true" path="promotion"/> Voyage en promotion</form:label>
			</div>
			<div class="checkbox">
				<form:label path="promotion"><form:input type="radio" value="false" path="promotion"/> Voyage non remisé</form:label>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="remiseVoyage">Prix remisé du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="remiseVoyage"
					path="remiseVoyage" />
			</div>
		</div>
		<div class="form-group">
			<label for="InputFile">Photo de la Destination</label> 
			<input type="file" accept="image/png, image/jpeg, image/gif" id="InputFile" value="" />
		</div>
		<button type="submit" class="btn btn-default">Ajouter cette
			offre de voyage</button>
	</form:form>


	<h1 style="color: red; text-align: center">${error}</h1>

</body>
</html>