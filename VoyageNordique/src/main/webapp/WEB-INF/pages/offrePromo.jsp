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
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettrePromoOffre" modelAttribute="offrePromo"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noVoyage"
					path="noVoyage" />
			</div>
		</div>
		<div class="radio">
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="true"> Voyage en promotion
			</form:label>
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="false" />
				Voyage au prix initial
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

		<button type="submit" class="btn btn-default">Modifier cette
			offre de voyage</button>
	</form:form>


	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">La mise en promotion
			de l'offre a échouée.</h1>
	</c:if>

</body>
</html>