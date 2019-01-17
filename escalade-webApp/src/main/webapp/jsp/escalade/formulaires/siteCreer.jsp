<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer un site</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="../../include/navigation.jsp" %>

			<h1>Création d'un site de grimpe</h1>
			
			<s:actionerror/>
			
			<form action="creerSite">
				<div class="form-group">
					<s:textfield class="form-control" name="nom" placeholder="Nom" />
				</div>
				<div class="form-group">
					<s:textarea class="form-control" name="presentation" placeholder="Présentation" />
				</div>
				<div class="form-group">
					<s:textfield class="form-control" name="localite" placeholder="Localite" />
				</div>
				<div class="form-group">
					<s:textfield class="form-control" name="codePostal" placeholder="Code postal" />
				</div>
				<button type="submit" class="btn btn-primary">Créer</button>
			</form>

		
		</div>

	</body>

</html>