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
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />

	<form:form cssClass="form-horizontal" method="POST"	action="soumettreAjoutClient" modelAttribute="clientAjout" enctype = "multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="noClient">Numero référence du Client</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="numero Client" path="noClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="nomClient">Nom Client</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="nom Client" path="nomClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="prenomClient">Prenom Client</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="prenom Client" path="prenomClient" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="dn">Date de Naissance</form:label>
			<div class="col-xs-3">
				<form:input type="date" cssClass="form-control" placeholder="Date de Naissance du client" path="dn" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="mail">Mail</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="mail Client" path="mail" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="mdp">Mot de passe</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="mot de passe du Client" path="mdp" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="tel">Telephone</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="telephone du Client" path="tel" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-default">Ajouter Client</button>
			</div>
		</div>
	</form:form>


	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>