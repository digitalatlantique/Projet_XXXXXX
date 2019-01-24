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
					
			<s:a action="creerSecteur">Créer un secteur</s:a>
			
			<s:actionmessage/>
			
			<s:iterator value="site.secteurs">
			
				<h3>Secteur : <s:property value="nom"/></h3>					
				
				<s:a action="modifierSecteur">Modifier
					<s:param name="idSecteur" value="id" />
				</s:a>
				<s:a action="supprimerSecteur">Supprimer
					<s:param name="idSecteur" value="id" />
				</s:a><br>
				
				Hauteur : <s:property value="hauteur"/> m<br>
				<img src="images/images_secteurs/<s:property value="imagePath"/>"/><br>
				
				<s:a action="creerVoie">Créer une voie
					<s:param name="idSecteur" value="id"/>
				</s:a>
				
				<s:iterator value="voies">
					<h4>Voie n° : <s:property value="numero"/></h4>
					<s:a action="modifierVoie">Modifier
						<s:param name="idVoie" value="id"/>
					</s:a>
					<s:a action="supprimerVoie">Supprimer
						<s:param name="idVoie" value="id"/>
					</s:a>
					<ul>
						<li>Nom : <s:property value="nom"/></li>
						<li>Cotation : <s:property value="cotation"/></li>
					</ul>
				</s:iterator>
				
			</s:iterator>
		</div>
	
	</body>
</html>