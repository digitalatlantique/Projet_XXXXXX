<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes topos</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<s:head />
	</head>
	
	<body>
	
		<div class="container">
		
			<%@include file="../include/navigation.jsp" %>
	
			<h1>Liste de mes topos</h1>
			
			<s:a action="creerTopo">Créer un topo</s:a>
			
			<s:actionmessage/>
			
			<s:if test="topos">
				<s:iterator value="topos">			
					<s:a action="monTopoDetail">						
						<h2><s:property value="libelle"/></h2>					
						<s:param name="topoId" value="id"/>					
					</s:a>
					<s:a action="modifierTopo">Modifier
						<s:param name="topoId" value="id" />
					</s:a>
					<s:a action="supprimerTopo">Supprimer
						<s:param name="topoId" value="id"/>
					</s:a>
					<h3>Information du topo</h3>
					
					<s:if test="autoriserLocation">Ce topo est autorisé à la location</s:if>
					<s:else>Ce topo n'est pas autorisé à la location</s:else>
					<br>
					<s:property value="information"/> 			
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>