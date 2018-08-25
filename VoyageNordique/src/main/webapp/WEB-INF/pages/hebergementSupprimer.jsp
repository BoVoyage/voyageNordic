<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de suppression d'une offre de voyage</title>

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
		action="soumettreSupprHeb" modelAttribute="hebSuppr">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nomHebergement">Nom de l'hébergement</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="nomHebergement"
					path="nomHebergement" />
			</div>
		</div>
		<button type="submit" class="btn btn-default">Supprimer
			l'hébergement</button>
	</form:form>
	
	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>