<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- besoin des balises form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ma page Ajout Client</title>
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
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="color: white">
  <b>S'inscrire en tant que Client</b>
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title" id="exampleModalLabel" style="color: blue; text-align: center"><b>Inscription Client</b></h1>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
		<!-- ********$$$$$$$$$$$$$$*************** -->
		
        <form:form cssClass="form-horizontal" method="POST"	action="soumettreAjoutClient" modelAttribute="AjoutClient" enctype = "multipart/form-data">
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="nomClient" cssStyle="color: blue">Nom Client</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="nom Client" path="nomClient" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="prenomClient" cssStyle="color: blue">Prenom Client</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="prenom Client" path="prenomClient" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="dn" cssStyle="color: blue">Date de Naissance</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control" placeholder="Date de Naissance du client" path="dn" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="mail" cssStyle="color: blue">Mail</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="mail Client" path="mail" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="mdp" cssStyle="color: blue">Mot de passe</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="mot de passe du Client" path="mdp" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-xs-3 control-label" path="tel" cssStyle="color: blue">Telephone</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="telephone du Client" path="tel" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-xs-10">
				<button type="submit" class="btn btn-primary">Ajouter Client</button>
			</div>
		</div>
	</form:form>

		<!-- ********$$$$$$$$$$$$$$*************** -->

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Annuler Ajout Client</button>

      </div>
    </div>
  </div>
</div>
		<h1 style="color: red; text-align: center">${msg}</h1>
<!-- ********************************************************************************************** -->


</body>
</html>