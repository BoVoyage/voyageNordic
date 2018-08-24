<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

<title>Ligne Commande Page</title>
</head>
<body>
	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>
	<form:form cssClass="form-horizontal" metho="POST"
		action="soumettreUpdateLigneCommande" modelAttribute="lcModif">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="idLigneCommande">ID</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id"
					path="idLigneCommande" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="quantite">Nb de place</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="nb de place voulue"
					path="quantite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prix">Prix</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control"
					placeholder="prix de la commande" path="prix" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Modifier</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: blue">${msg}</h1>
</body>
</html>