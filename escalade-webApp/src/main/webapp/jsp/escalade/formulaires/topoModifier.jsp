<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifier un topo</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/topoCreer.css">
	</head>
	
	<body class="container-fluid">
		<%@include file="../../include/navigation.jsp" %>
		<div class="container">
			
			<s:actionerror/>
			<div class="formulaire">
				<form action="modifierTopo">
					<fieldset>
						<legend>Modifier le topo</legend>
						<div class="form-group">
							<s:textfield class="form-control" name="libelle" value="%{#attr['libelle']}" placeholder="Nom du topo" />
						</div>
						
						<div class="form-group">
							<s:textarea class="form-control" name="information" value="%{#attr['information']}" placeholder="Information" />
						</div>
			
						<div class="form-group">
							<s:checkbox name="autoriserLocation" value="true" fieldValue="true" label="Autoriser la location."/>
						</div>
						
						<s:hidden name="topoId" value="%{topoId}"/>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</fieldset>
				</form>
			</div>			
	
				
		</div>
	</body>
</html>