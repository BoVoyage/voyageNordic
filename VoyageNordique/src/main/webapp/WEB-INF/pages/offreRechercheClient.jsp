<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de recherche d'un voyage</title>

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
	
	<div class="container">
  <h2>Ce que nous avons à vous proposer !</h2>
  <p>Tapez ici votre recherche:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="mots-clés">
  <br>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Destination</th>
        <th>Descriptif</th>
        <th>Date de départ</th>
        <th>Date de retour</th>
      </tr>
    </thead>
    <tbody id="myTable">
    <c:forEach var="o" items="${allOffresVoyage}">
      <tr>
        <td>${o.designation}</td>
        <td>${o.pays}</td>
        <td>${o.descriptionVoyage}</td>
        <td>${o.dateDepart}</td>
        <td>${o.dateRetour}</td>
      </c:forEach>
    </tbody>
  </table>
  
</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
	

</body>
</html>