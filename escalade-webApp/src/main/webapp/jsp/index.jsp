<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade-index</title>
	</head>
	
	<body>
		<h1>Bienvenue sur le site communautaire de l'escalade</h1>
		
		<h2>Dernier site ajouté : </h2>
		
		<h3><s:property value="dernierSite.nom"/></h3>
		Présentation :
		<p>
			 
			<s:property value="dernierSite.presentation"/>
		</p>
		Localité : <s:property value="dernierSite.localite"/> <br>
		Code postal : <s:property value="dernierSite.codePostal"/>

	</body>

</html>
