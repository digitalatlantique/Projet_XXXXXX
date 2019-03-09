<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes topos</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/mesTopos.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		<div class="container">		
	
			<h1>Liste de mes topos</h1>
			<div class="creer">
				<s:a action="creerTopo">Créer un topo</s:a>			
			</div>

			
			<s:actionmessage/>
			
			<s:if test="topos">
				<s:iterator value="topos">	
				
					<section>
						<s:a action="monTopoDetail">						
							<h2><s:property value="libelle"/></h2>					
							<s:param name="topoId" value="id"/>					
						</s:a>
						<span class="modifier">
							<s:a action="modifierTopo">Modifier
								<s:param name="topoId" value="id" />
							</s:a>					
						</span>
						<span class="supprimer">
							<s:a action="supprimerTopo">Supprimer
								<s:param name="topoId" value="id"/>
							</s:a>					
						</span>
	
						<h3>Information du topo</h3>
						<p id="autoriser">
							<s:if test="autoriserLocation">Ce topo est autorisé à la location</s:if>
							<s:else>Ce topo n'est pas autorisé à la location</s:else>
						</p>
						<p>
							<s:property value="information"/> 
						</p>						
					</section>		
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>