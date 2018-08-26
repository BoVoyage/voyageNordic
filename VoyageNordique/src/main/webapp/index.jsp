<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index JSP Lancement</title>
</head>
<body>

	<!-- Redirection vers une page jsp -->
	<%
		response.sendRedirect("offreVoyage/accueil");
	%>
</body>
</html>