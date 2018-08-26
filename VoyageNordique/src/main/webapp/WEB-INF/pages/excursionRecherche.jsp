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
		action="soumettreSearchExcursion" modelAttribute="SearchExcursion">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nomExcursion">Nom de l'excursion</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="Nom Excursion"
					path="nomExcursion" />
			</div>
		</div>

		<button type="submit" class="btn btn-default">Rechercher une
			excursion</button>
	</form:form>
	
<table class="table table-bordered">
		<tr>
			<th>Numéro Excursion</th>
			<th>Nom Excursion</th>
			<th>Descriptif</th>
			<th>Prix TTC</th>
			<th>Présentation Photo</th>
		</tr>

		<c:forEach var="e" items="${listeSearchExcursion}">
			<tr>
				<td>${e.idExcursion}</td>
				<td>${e.nomExcursion}</td>
				<td>${e.descriptionExcursion}</td>
				<td>${e.prixExcursion}</td>

				<td><img
					src="${pageContext.request.contextPath}/excursion/getImage?pId=${e.idExcursion}"
					style="width: 100px; height: 100px" /></td>
			</tr>
		</c:forEach>

	</table>


	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Aucune excursion ne porte ce nom !</h1>
	</c:if>

</body>
</html>