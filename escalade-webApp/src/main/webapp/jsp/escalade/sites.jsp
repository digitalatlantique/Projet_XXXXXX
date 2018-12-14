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
		
			<%@include file="../include/navigation.jsp" %>
	
			<h1>Liste des sites</h1>
			
			<s:iterator value="sites">
			
				<h2><s:property value="nom"/></h2>
				Localité : <s:property value="codePostal"/> <s:property value="localite"/>
				<p><s:property value="presentation"/></p>			
			
			</s:iterator>
		
		</div>
	</body>
</html>