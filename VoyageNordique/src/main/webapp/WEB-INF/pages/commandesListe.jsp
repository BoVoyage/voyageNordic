<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<table class="table table-bordered">
		<tr>
			<th>Num�ro Commande</th>
			<th>Date Commande</th>
			<th>Gestion</th>
		</tr>

		<c:forEach var="co" items="${allCommandes}">
			<tr>
				<td>${co.noCommande}</td>
				<td><fmt:formatDate value="${co.dateCommande}" pattern="dd/MM/yyyy" /></td>
				<td><a href="<c:url value="/commande/supprLink/${co.noCommande}"/>">Supprimer</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>