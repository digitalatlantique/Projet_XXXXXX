<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade site détail</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/mesSecteurs.css">
		<s:head />
	</head>
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		<div class="container">			
	
			<h1><s:property value="site.nom"/></h1>
			
			<div class="creer">
				<s:a action="creerSecteur">Créer un secteur</s:a>
			</div>		
			
			<s:actionmessage/>
			
			<s:iterator value="site.secteurs">
				<div class="secteur">
					<h3>Secteur : <s:property value="nom"/></h3>					
					<span class="gras">Hauteur : </span><s:property value="hauteur"/> m<br>				
				</div>

				<span class="modifier">
					<s:a action="modifierSecteur">Modifier
						<s:param name="idSecteur" value="id" />
					</s:a>				
				</span>

				<span class="supprimer">
					<s:a action="supprimerSecteur">Supprimer
						<s:param name="idSecteur" value="id" />
					</s:a>			
				</span><br>
				
				<div class="creer">
					<s:a action="creerVoie">Créer une voie
						<s:param name="idSecteur" value="id"/>
					</s:a>				
				</div>
				
				

				<img src="images/images_secteurs/<s:property value="imagePath"/>"/><br>
				<div id="voies">
					<s:iterator value="voies">
						<h4>Voie n° : <s:property value="numero"/></h4>
						<div id="voie">
							<span class="modifier">
								<s:a action="modifierVoie">Modifier
									<s:param name="idVoie" value="id"/>
								</s:a>					
							</span>
							<span class="supprimer">
								<s:a action="supprimerVoie">Supprimer
									<s:param name="idVoie" value="id"/>
								</s:a>
							</span>
		
							<ul>
								<li>Nom : <s:property value="nom"/></li>
								<li>Cotation : <s:property value="cotation"/></li>
							</ul>
						</div>
					</s:iterator>
				</div>
				
			</s:iterator>
		</div>
	
	</body>
</html>