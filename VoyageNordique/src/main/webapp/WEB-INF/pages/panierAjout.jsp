<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Heimdall Voyage: bon plans voyages, hotels, vols sur les
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
	<%@ include file="../../templates/header.html"%>

	<br />

	<form:form commandName="panier" cssClass="form-horizontal"
		method="POST" action="soummettreAddOffrePanier"
		modelAttribute="panAjout" enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label"
				path="ligneCommande.offrevoyage.designation">Nom du voyage</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control"
					placeholder="Entrez le nom du voyage"
					path="ligneCommande.offrevoyage.designation" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label"
				path="ligneCommande.quantite">Nb de place</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="Combien de place ?"
					path="ligneCommande.quantite" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-default">Ajouter au
					panier</button>
			</div>
		</div>
	</form:form>


	<h1 style="color: red; text-align: center">${error}</h1>

</body>
</html>