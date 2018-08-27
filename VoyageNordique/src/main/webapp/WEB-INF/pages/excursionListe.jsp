<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

	<table class="table table-bordered">
		<tr>
			<th>Numéro Excursion</th>
			<th>Nom Excursion</th>
			<th>Descriptif</th>
			<th>Prix TTC</th>
			<th>Présentation Photo</th>
		</tr>

		<c:forEach var="e" items="${allExcursions}">
			<tr>
				<td>${e.idExcursion}</td>
				<td>${e.nomExcursion}</td>
				<td>${e.descriptionExcursion}</td>
				<td>${e.prixExcursion}</td>

				<td><img
					src="${pageContext.request.contextPath}/excursion/getImage?pId=${e.idExcursion}"
					style="width: 150px; height: 125px" /></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>