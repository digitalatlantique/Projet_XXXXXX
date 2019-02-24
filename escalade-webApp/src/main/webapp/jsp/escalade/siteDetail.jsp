<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade site détail</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<s:head />
	</head>
	<body>
	
		<div class="container">
		
			<%@include file="../include/navigation.jsp" %>
	
			<h1>Détail du site</h1>

			<h2><s:property value="site.nom"/></h2>		
	
			<s:iterator value="site.secteurs">
				<h3>Secteur : <s:property value="nom"/></h3>
				
				Hauteur : <s:property value="hauteur"/> m<br>
				<img src="images/images_secteurs/<s:property value="imagePath"/>"/>
				
					<s:iterator value="voies">
						<h4>Voie n° : <s:property value="numero"/></h4>
					<ul>
						<li>Nom : <s:property value="nom"/></li>
						<li>Cotation : <s:property value="cotation"/></li>
					</ul>
					</s:iterator>
				
			</s:iterator>	
			
			<s:actionerror/>		
			<s:form action="ajouterCommentaire">
			
				<s:textarea label="Commentaire" name="commentaire"/>
				<s:hidden name="id" value="%{id}"/>
				<s:submit class="btn btn-primary" value="Envoyer"/>
			
			</s:form>
			
			<s:iterator value="commentaires">
				<h3>Commentaire</h3>				
				<p><s:property value="commentaire"/></p>
				<h4> De : <s:property value="membre.prenom"/> <s:property value="membre.nom"/></h4>
			</s:iterator>
		</div>
	
	</body>
</html>