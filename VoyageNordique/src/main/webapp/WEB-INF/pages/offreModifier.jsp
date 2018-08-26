<%@page import="fr.adaming.model.OffreVoyage"%>
<%@page import="fr.adaming.service.OffreVoyageServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de modification d'une offre</title>
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

</head>
<body>

	<!-- Ajouter le menu avec include -->
	<%@ include file="../../templates/header.html"%>

	<br />
	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifOffre" modelAttribute="offreModif"
		enctype="multipart/form-data">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="noVoyage">N° référence du Voyage</form:label>
			<div class="col-sm-9" id="listeNo">
<%-- 				<form:input cssClass="form-control" placeholder="noVoyage"> --%>
					<SELECT name="listeNo" size="1">
						<%
							final Iterator<String> listeNoVoyage = listingNoVoyage.iterator();
									while (listeNoVoyage.hasNext()) {
										OffreVoyage ov = listeNoVoyage.next();
						%>
						<OPTION value="<%=ov.getNoVoyage()%>"><%=ov.getNoVoyage()%></OPTION>
						<%
							}
						%>
					</SELECT>
<%-- 				</form:input> --%>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="designation">Nom du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="designation"
					path="designation" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="pays" path="pays" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="ville">Ville</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="ville" path="ville" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="descriptionVoyage">Description du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="descriptionVoyage"
					path="descriptionVoyage" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateDepart">Date de départ</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="date de Depart"
					path="dateDepart" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateRetour">Date de retour</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="date de Retour"
					path="dateRetour" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="compagnieAerienne">Compagnie aérienne</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="compagnie Aerienne"
					path="compagnieAerienne" />
			</div>
		</div>
		<div class="radio">
			<form:label cssClass="col-sm-3 control-label" path="etat">
				<input type="radio" name="etat" value="true">
				Offre valide
			</form:label>
			<form:label cssClass="col-sm-3 control-label" path="etat">
				<input type="radio" name="etat" value="false">
				Offre close
			</form:label>
		</div>
		<br />
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="quantite">Quantite</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="quantite"
					path="quantite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixVoyage">Prix initial du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="prixVoyage"
					path="prixVoyage" />
			</div>
		</div>
		<div class="radio">
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="true"> Voyage en promotion
			</form:label>
			<form:label cssClass="col-sm-4 control-label" path="promotion">
				<input type="radio" name="promotion" value="false" />
				Voyage non remisé
			</form:label>
		</div>
		<br />
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="remiseVoyage">Prix remisé du voyage</form:label>
			<div class="col-sm-9">
				<form:input cssClass="form-control" placeholder="remiseVoyage"
					path="remiseVoyage" />
			</div>
		</div>

		<input style="margin: auto" type="file" name="file" />

		<button type="submit" class="btn btn-default">Modifier cette
			offre de voyage</button>
	</form:form>


	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Une erreur est survenue lors de la modification de l'offre !</h1>
	</c:if>

</body>
</html>