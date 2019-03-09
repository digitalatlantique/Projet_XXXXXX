<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifier secteur</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/secteurCreer.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../../include/navigation.jsp" %>
		
		<div class="container">
			<s:actionerror/>
			<div class="formulaire">
				<form action="modifierSecteur">
					<fieldset>
					<legend>Modifier secteur</legend>
						<div class="form-group">
							<s:textfield class="form-control" name="nom" value="%{#attr['nom']}" placeholder="Nom" />
						</div>
						<div class="form-group">
							<s:textfield class="form-control" name="hauteur" value="%{#attr['hauteur']}" placeholder="Hauteur" />
						</div>
						<s:hidden name="idSecteur" value="%{idSecteur}"></s:hidden>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</fieldset>
				</form>	
			</div>			
		</div>
	</body>
</html>