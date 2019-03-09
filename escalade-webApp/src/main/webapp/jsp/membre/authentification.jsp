<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Authentification</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/authentification.css">
	</head>
	
	<body class="container-fluid">
	
		<div>
						
			<%@include file="../include/navigation.jsp" %>
			
			<s:actionmessage/>
			<s:actionerror/>
			
			<div class="formulaire">
				<form action="membre" >
				
					<fieldset>
					<legend>Authentification</legend>	
						<div class="form-group">
							<s:textfield class="form-control" name="email" placeholder="Votre email" />
						</div>
						<div class="form-group">
							<s:password class="form-control" name="password" placeholder="Mot de passe" />
						</div>
						<s:submit value="Connexion" class="btn btn-primary"></s:submit><br>
						<s:a action="inscription">Inscription</s:a>										
					</fieldset>

				</form>				
			</div>
	
		</div>

	</body>

</html>