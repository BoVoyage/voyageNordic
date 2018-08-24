<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<form:form cssClass="form-inline" action="soumettreRechCommande"
		method="POST" modelAttribute="coRech">
		<div class="form-group">
			<form:label path="noCommande">N° Commande: </form:label>
			<form:input type="text" class="form-control" path="noCommande" />
		</div>
		<div>
			<button type="submit" cssClass="btn btn-default">Rechercher</button>
		</div>
	</form:form>
	
<h1 style="color: red; text-align: center">${msg}</h1>
	
	
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


</body>
</html>