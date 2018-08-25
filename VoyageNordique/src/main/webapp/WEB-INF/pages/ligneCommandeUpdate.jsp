<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<title>Ligne Commande Page</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>
	<form:form cssClass="form-horizontal" metho="POST"
		action="soumettreUpdateLigneCommande" modelAttribute="lcModif">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idLigneCommande">ID</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id"
					path="idLigneCommande" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="quantite">Nb de place</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="nb de place voulue"
					path="quantite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prix">Prix</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control"
					placeholder="prix de la commande" path="prix" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Modifier</button>
			</div>
		</div>
	</form:form>

	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">La modification n'a pu être prise en compte</h1>
	</c:if>
</body>
</html>