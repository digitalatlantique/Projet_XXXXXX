<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifier site</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="../include/navigation.jsp" %>

			<h1>Modifier un site de grimpe</h1>
			
			<s:actionerror/>
			
			<form action="modifierSite">
				<div class="form-group">
					<s:textfield class="form-control" name="nom" value="%{#attr['nom']}" placeholder="Nom" />
				</div>
				<div class="form-group">
					<s:textarea class="form-control" name="presentation" value="%{#attr['presentation']}" placeholder="Présentation" />
				</div>
				<div class="form-group">
					<s:textfield class="form-control" name="localite" value="%{#attr['localite']}" placeholder="Localite" />
				</div>
				<div class="form-group">
					<s:textfield class="form-control" name="codePostal" value="%{#attr['codePostal']}" placeholder="Code postal" />
				</div>
				<s:hidden name="id" value="%{id}"></s:hidden>
				<button type="submit" class="btn btn-primary">Modifier</button>
			</form>

		
		</div>

	</body>

</html>