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

<title>Ma page liste Clients</title>
</head>
<body>

<table class="table table-bordered">

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>
	
		<tr>
			<th>Numéro Client</th>
			<th>Nom Client</th>
			<th>Prenom Client</th>
			<th>Date de Naissance</th>
			<th>Mial</th>
			<th>Mot de passe</th>
			<th>Telephone</th>
			
		</tr>

		<c:forEach var="cl" items="${LesClients}">
			<tr>
				<td>${cl.noClient}</td>
				<td>${cl.nomClient}</td>
				<td>${cl.prenomClient}</td>
				<td>${cl.dn}</td>
				<td>${cl.mail}</td>
				<td>${cl.mdp}</td>
				<td>${cl.tel}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>