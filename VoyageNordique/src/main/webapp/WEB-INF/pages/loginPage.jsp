<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div
		style="margin-bottom: 5%; margin-left: 15%; margin-right: 15%; margin-top: 5%; width: 70%; text-align: center;">
		<form action="j_spring_security_check" method="post">
			<div style="margin: 5px">
				Email (client) ou Numéro d'Identification (conseiller): <input
					type="text" name="j_username" />
			</div>
			<br />
			<div style="margin: 5px">
				Password: <input type="text" name="j_password" />
			</div>
			<br /> <input type="submit" value="Se Connecter" />
			
		</form>
		<br /> <a
			href="${pageContext.request.contextPath}/client/ajouterClient"
			style="color: #4172c1;; background-color: #ffffff">Pas encore
			inscrit? Créez un compte!</a>
	</div>
	<c:if test="${not empty echec}">
		<h1 style="color: red; text-align: center">Le mot de passe ou le
			login est erroné.</h1>
	</c:if>
	<c:if test="${not empty msg}">
		<h1 style="color: red; text-align: center">Vous êtes déconnecté.</h1>
	</c:if>



</body>
</html>