<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bifrost Voyage: bon plans voyages, hotels, vols sur les
	pays nordiques</title>
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
<!-- ********************************************************************************************** -->
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="color: white; margin-left: 40%; margin-right: 30%">
  <b>Cr�er un nouveau compte "Client"</b>
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title" id="exampleModalLabel" style="color: blue; text-align: center"><b>Nouveau compte</b></h1>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
		<!-- ********$$$$$$$$$$$$$$*************** -->
		
        <form:form cssClass="form-horizontal" method="POST"	action="soumettreAjoutClient" modelAttribute="AjoutClient" enctype = "multipart/form-data">
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="nomClient" cssStyle="color: blue">Nom</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Lothbrok" path="nomClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="prenomClient" cssStyle="color: blue">Prenom</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Ragnar" path="prenomClient" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="dn" cssStyle="color: blue">Date de Naissance</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control" placeholder="8�me si�cle" path="dn" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="mail" cssStyle="color: blue">Mail</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="@viking" path="mail" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="mdp" cssStyle="color: blue">Mot de passe</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="viking" path="mdp" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="tel" cssStyle="color: blue">Telephone</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Signaux de fum�e" path="tel" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-10">
				<button type="submit" class="btn btn-primary">S'inscrire</button>
			</div>
		</div>
	</form:form>

		<!-- ********$$$$$$$$$$$$$$*************** -->

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Annulation client</button>

      </div>
    </div>
  </div>
</div>
		
	<c:if test="${not empty error}">
		<h1 style="color: red; text-align: center">Une erreur est survenue lors de l'ajout du client !</h1>
	</c:if>
<!-- ********************************************************************************************** -->


</body>
</html>