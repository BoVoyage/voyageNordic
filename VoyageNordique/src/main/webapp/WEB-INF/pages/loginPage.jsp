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

	<form action="j_spring_security_check" method="post">
		Email: <input type="text" name="j_username" /> <br /> Password: <input
			type="text" name="j_password" /> <br /> <input type="submit"
			value="Se Connecter" />
	</form>
<br/>
<a href="${pageContext.request.contextPath}/client/ajouterClient" style="color: #ffffff; ; background-color: #4172c1">Pas encore inscrit? Créez un compte</a>

	<c:if test="${not empty echec}">
		<h1 style="color: red; text-align: center">Le mot de passe ou le
			login est erroné.</h1>
	</c:if>
	<c:if test="${not empty msg}">
		<h1 style="color: red; text-align: center">Vous êtes déconnecté.</h1>
	</c:if>



</body>
</html>