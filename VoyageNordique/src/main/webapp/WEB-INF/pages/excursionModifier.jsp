<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
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
	<%@ include file="../../templates/headerBack.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifExcursion" modelAttribute="excursionModif"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idExcursion">Excursion n°</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="Id Excursion"
					path="idExcursion" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nomExcursion">Nom de l'excursion</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="Nom Excursion"
					path="nomExcursion" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="descriptionExcursion">Description de l'excursion</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="description Excursion" path="descriptionExcursion" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixExcursion">Prix TTC</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prix Excursion" path="prixExcursion" />
			</div>
		</div>

		<input style="margin: auto;" type="file" name="file" />

		<button type="submit" class="btn btn-default">Modifier cette
			excursion</button>
	</form:form>


	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Une erreur est survenue lors de la modifcation de l'excursion</h1>
	</c:if>

</body>
</html>