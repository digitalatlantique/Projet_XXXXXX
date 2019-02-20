<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade-index</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="include/navigation.jsp" %>
			
			<h1>Bienvenue sur le site communautaire de l'escalade</h1>
			
			<h2>Dernier site ajouté : </h2>
			<s:a action="siteDetail">
				<h3><s:property value="dernierSite.nom"/></h3>
				<s:param name="id" value="dernierSite.id"/>
			</s:a>
			
			<img src="images/images_sites/<s:property value="dernierSite.imagePath"/>"/>
			<p>				 
				<s:property value="dernierSite.presentation"/>
			</p>
			Localité : <s:property value="dernierSite.localite"/> <br>
			Code postal : <s:property value="dernierSite.codePostal"/>
		
		</div>

	</body>

</html>
