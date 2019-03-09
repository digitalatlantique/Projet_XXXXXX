<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Créer un topo</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/topoCreer.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../../include/navigation.jsp" %>
		<div class="container">
		
			<s:actionerror/>
			<div class="formulaire">
				<form action="creerTopo">
				
					<fieldset>
						<legend>Nouveau topo</legend>				
				
						<div class="form-group">
							<s:textfield class="form-control" name="libelle" placeholder="Nom du topo" />
						</div>
						<div class="form-group">
							<s:textarea class="form-control" name="information" placeholder="Information" />
						</div>
		
						<div class="form-group">
							<s:checkbox name="autoriserLocation" value="true" fieldValue="true" label="Autoriser la location."/>
						</div>
						<button type="submit" class="btn btn-primary">Créer</button>
					</fieldset>
				</form>		
			</div>		

				
		</div>
	</body>
</html>