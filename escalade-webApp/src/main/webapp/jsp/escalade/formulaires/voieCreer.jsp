<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer une voie</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/voiecreer.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../../include/navigation.jsp" %>
		<div class="container">
			
			<s:actionerror/>
			
			<div class="formulaire">
				<form action="creerVoie">
				
					<fieldset>
						<legend>Nouvelle voie</legend>				

						<div class="form-group">
						  	<s:textfield class="form-control" placeholder="Numéro" name="numero" />
						</div>
						<div class="form-group">
						  	<s:textfield class="form-control" placeholder="Nom" name="nom" />
						</div>
						<div class="form-group">
						  	<s:textfield class="form-control" placeholder="Cotation" name="cotation" />
						</div>
						<s:hidden name="idSecteur" value="%{idSecteur}"/>
						<div class="form-group">
						  <s:submit class="btn btn-primary" value="Valider"/>
						</div>
			  
					</fieldset>
				</form>
			</div>			

		</div>
	</body>
</html>