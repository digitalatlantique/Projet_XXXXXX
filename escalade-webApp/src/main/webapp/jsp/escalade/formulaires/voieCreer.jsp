<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer une voie</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="../../include/navigation.jsp" %>

			<h1>Création d'une voie</h1>
			
			<s:actionerror/>
			
			<form action="creerVoie">
			
				<fieldset class="form-group">
				
					<div class="form-row">
						<div class="col-md-3">
						  	<s:textfield class="form-control" placeholder="Numéro" name="numero" />
						</div>
						<div class="col-md-3">
						  	<s:textfield class="form-control" placeholder="Nom" name="nom" />
						</div>
						<div class="col-md-3">
						  	<s:textfield class="form-control" placeholder="Cotation" name="cotation" />
						</div>
						<s:hidden name="idSecteur" value="%{idSecteur}"/>
						<div class="col-md-3">
						  <s:submit class="btn btn-primary" value="Valider"/>
						</div>
					</div>
				  
				</fieldset>
			</form>
		</div>
	</body>
</html>