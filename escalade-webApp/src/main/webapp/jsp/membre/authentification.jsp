<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Membre</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="../include/navigation.jsp" %>

			<h1>Authentification</h1>
			
			<s:actionerror/>
			
			<form action="membre">
				<div class="form-group">
					<s:textfield class="form-control" name="email" placeholder="Votre email" />
				</div>
				<div class="form-group">
					<s:password class="form-control" name="password" placeholder="Mot de passe" />
				</div>
				<button type="submit" class="btn btn-primary">Connexion</button>
			</form>

		
		</div>

	</body>

</html>