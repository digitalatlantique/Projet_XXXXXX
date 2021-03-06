<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade-index</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/sites.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		
		<div class="container">
		
			
	
			<h1>Liste des sites</h1>
			
			<s:if test="#session.sites">
				<s:iterator value="#session.sites">	
				
					<section>
						<s:a action="siteDetail">						
							<h2><s:property value="nom"/></h2>					
							<s:param name="id" value="id"/>					
						</s:a>
						<span class="gras">Localité : </span><s:property value="codePostal"/> <s:property value="localite"/><br>
						<img src="images/images_sites/<s:property value="imagePath"/>"/>
						<p><s:property value="presentation"/></p>	
					</section>		
		
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>