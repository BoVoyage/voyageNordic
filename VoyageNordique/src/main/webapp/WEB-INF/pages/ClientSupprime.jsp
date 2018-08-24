<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ma page Modifier Client</title>

<!-- ajouter la librairie de bootstrap.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>


<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />

	<form:form cssClass="form-horizontal" method="POST"	action="soumettreSupprimeClient" modelAttribute="clientSupprime" enctype = "multipart/form-data">
		
		<div class="form-group">
			<form:label cssClass="col-xs-2 control-label" path="noClient">Numero référence du Client</form:label>
			<div class="col-xs-3">
				<form:input cssClass="form-control" placeholder="numero Client" path="noClient" />
			</div>
		</div>

<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-default">Supprimer Client</button>
			</div>
		</div>
	</form:form>


	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>