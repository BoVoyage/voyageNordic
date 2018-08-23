<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ma page Ajout Client</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>

	<form:form cssClass="form-horizontal" method="POST"	action="soumettreAjoutClient" modelAttribute="clientAjout" enctype = "multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noClient">N° référence du Client</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noClient"
					path="noClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nomClient">Nom Client</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="nomClient" path="nomClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prenomClient">Prenom Client</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prenomClient" path="prenomClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mail">Mail</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="mail"
					path="mail" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mdp">Mot de passe</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="mdp"
					path="mdp" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="tel">Telephone</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="tel" path="tel" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dn">Date de Naissance</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="dn" path="dn" />
			</div>
		</div>

		<button type="submit" class="btn btn-default">Ajouter client</button>
	</form:form>


	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>