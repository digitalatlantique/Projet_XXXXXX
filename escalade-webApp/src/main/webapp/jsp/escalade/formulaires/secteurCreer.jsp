<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer un secteur</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/secteurCreer.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../../include/navigation.jsp" %>
		
		<div class="container">			
			
			<s:actionerror/>
			
			<div class="formulaire">
				<form action="creerSecteur">
					<fieldset>
						<legend>Nouveau secteur</legend>
						<div class="form-group">
							<s:textfield class="form-control" name="nom" placeholder="Nom" />
						</div>
						<div class="form-group">
							<s:textfield class="form-control" name="hauteur" placeholder="Hauteur" />
						</div>
						<s:hidden name="id" value="%{id}"/>
						<button type="submit" class="btn btn-primary">Créer</button>					
					</fieldset>
				</form>				
			</div>
			

		
		</div>

	</body>

</html>