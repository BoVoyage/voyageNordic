<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<%@ include file="../../templates/headerBack.html"%>

	<form:form cssClass="form-inline" action="soumettreRechCommande"
		method="POST" modelAttribute="coRech">
		<div class="form-group">
			<form:label for="pNoCom" path="noCommande">N° Commande: </form:label>
			<form:select id="pNoCom" path="noCommande" multiple="true">
				<form:option value="1" label="..."></form:option>
				<form:options items="${co.noCommande}" />
			</form:select>
		</div>
		<div>
			<button type="submit" cssClass="btn btn-default">Rechercher</button>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>
	<c:if test="${not empty coFind}">
		<table class="table table-bordered">
			<tr>
				<th>Numéro Commande</th>
				<th>Date Commande</th>
				<th>Gestion</th>
			</tr>
			<tr>
				<td>${coFind.noCommande}</td>
				<td><fmt:formatDate value="${coFind.dateCommande}"
						pattern="dd/MM/yyyy" /></td>
				<td><a
					href="<c:url value="/commande/supprLink/${coFind.noCommande}"/>">Supprimer</a></td>
			</tr>
		</table>
	</c:if>
</body>
</html>