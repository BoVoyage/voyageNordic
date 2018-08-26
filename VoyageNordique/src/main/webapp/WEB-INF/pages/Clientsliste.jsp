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

<title>Ma page liste Clients</title>
</head>
<body>

<table class="table table-bordered">

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/headerBack.html"%>
	
		<tr>
			<th style="color: blue; text-align: center">ID Client</th>
			<th style="color: blue; text-align: center">No Client</th>
			<th style="color: blue; text-align: center">Nom Client</th>
			<th style="color: blue; text-align: center">Prenom Client</th>
			<th style="color: blue; text-align: center">Date de Naissance</th>
			<th style="color: blue; text-align: center">Mail</th>
			<th style="color: blue; text-align: center">Mot de passe</th>
			<th style="color: blue; text-align: center">Telephone</th>
			
		</tr>

		<c:forEach var="cl" items="${LesClients}">
			<tr>
				<td>${cl.idClient}</td>
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