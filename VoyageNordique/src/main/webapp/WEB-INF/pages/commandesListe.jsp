<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<p>Numéro de commande</p>
			</div>
			<div class="col-sm-1"></div>
			<c:forEach var="co" items="${allCommandes}">
				<div class="col-sm-3">
					<p>${co.noCommande}</p>
				</div>
			</c:forEach>

		</div>
		<div class="row">
			<div class="col-sm-1">
				<p>Date de la commande</p>
			</div>
			<div class="col-sm-2"></div>
			<c:forEach var="co" items="${allCommandes}">
				<div class="col-sm-3">
					<p>
						<fmt:formatDate value="${co.dateCommande}" pattern="dd/MM/yyyy" />
					</p>
				</div>
			</c:forEach>

		</div>
		<div class="row">
			<div class="col-sm-1">
				<p>Gestion</p>
			</div>
			<div class="col-sm-2"></div>
			<c:forEach var="co" items="${allCommandes}">
				<div class="col-sm-3">
					<p>
						<a href="<c:url value="/commande/supprLink/${co.noCommande}"/>">Supprimer</a>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>