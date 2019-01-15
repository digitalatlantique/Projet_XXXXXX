<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes sites</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<s:head />
	</head>
	
	<body>
	
		<div class="container">
		
			<%@include file="../include/navigation.jsp" %>
	
			<h1>Mes sites</h1>

			<s:a action="formulaireSite">Créer un site</s:a>
			<s:actionmessage/>		
				
			<s:if test="#session.sites">
				<s:iterator value="#session.sites">			
					<s:a action="siteDetail">						
						<h2><s:property value="nom"/></h2>					
						<s:param name="id" value="id"/>					
					</s:a>
					<s:a action="modifierSite">Modifier
						<s:param name="id" value="id"/>	
					</s:a>
					<s:a action="supprimerSite">Supprimer
						<s:param name="id" value="id"/>	
					</s:a><br>
					Localité : <s:property value="codePostal"/> <s:property value="localite"/><br>
					<img src="images/images_sites/<s:property value="imagePath"/>"/>
					<p><s:property value="presentation"/></p>			
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>