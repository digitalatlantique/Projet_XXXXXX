<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes sites</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/mesSites.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
	
		<div class="container">			
	
			<h1>Mes sites</h1>

			<div class="creer">
				<s:a action="formulaireSite" >Créer un site</s:a>
			</div>
			
			<s:actionmessage/>		
				
			<s:if test="#session.sites">
				<s:iterator value="#session.sites">	
				
					<section>		
						<s:a action="mesSecteurs">						
							<h2><s:property value="nom"/></h2>					
							<s:param name="id" value="id"/>					
						</s:a>
						<span class="gras">Localité : </span><s:property value="codePostal"/> <s:property value="localite"/><br>
						<span class="modifier">
							<s:a action="modifierSite">Modifier
								<s:param name="id" value="id"/>	
							</s:a>			
						</span>
						<span class="supprimer">
							<s:a action="supprimerSite">Supprimer
								<s:param name="id" value="id"/>	
							</s:a>				
						</span><br>
	
						
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