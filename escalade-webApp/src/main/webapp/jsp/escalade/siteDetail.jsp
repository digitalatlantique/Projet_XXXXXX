<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade site détail</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/siteDetail.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
	
		<div class="container">			
	
			<h1><s:property value="site.nom"/></h1>
	
			<s:iterator value="site.secteurs">			
				<div class="secteur">
					<h3>Secteur : <s:property value="nom"/></h3>
					<span class="gras">Hauteur : </span><s:property value="hauteur"/> m				
				</div>				
				
				<div id="voies">				
					<s:iterator value="voies">
						<div id="voie">
							<h4>Voie n° : <s:property value="numero"/></h4>
							<ul>
								<li>Nom : <s:property value="nom"/></li>
								<li>Cotation : <s:property value="cotation"/></li>
							</ul>					
						</div>
					</s:iterator>
					<img src="images/images_secteurs/<s:property value="imagePath"/>"/><br>			
				</div>				
			</s:iterator>	
			
			<div class="commentaire">
				<s:form action="ajouterCommentaire">				
					<s:textarea label="Commentaire " name="commentaire"/>
					<s:hidden name="id" value="%{id}"/>
					<s:submit class="btn btn-primary" value="Envoyer"/>				
				</s:form>
			</div>
			<s:actionerror/>		

			<h2>Commentaires : </h2>
			<s:iterator value="commentaires">								
				<p><s:property value="commentaire"/></p>
				<h4><s:property value="membre.prenom"/> <s:property value="membre.nom"/></h4>
			</s:iterator>
		</div>
	
	</body>
</html>