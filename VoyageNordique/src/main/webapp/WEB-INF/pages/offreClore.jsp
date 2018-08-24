<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de clôture d'une offre</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreCloreOffre" modelAttribute="offreClose"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="noVoyage"
					path="noVoyage" />
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

		<button type="submit" class="btn btn-default">Modifier cette
			offre de voyage</button>
	</form:form>

	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">La clôture de l'offre a échouée.</h1>
	</c:if>

</body>
</html>