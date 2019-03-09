<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade-index</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/monTopoDetail.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		<div class="container">
		
			
	
			<h1>Liste des sites du topo</h1>
			
			<div class="formulaire">
				<s:form action="ajouterSiteAuTopo">
				
					<s:select label="Choisir un site " name="siteId" list="#session.sites" listKey="id" listValue="nom" />
					<s:hidden name="topoId" value="%{topoId}"></s:hidden>
					<s:submit value="Ajouter" class="btn btn-primary"/>
				</s:form>			
			</div>

			
			<s:if test="#session.sitesTopo">
				<s:iterator value="#session.sitesTopo">	
				
					<section>
						<s:a action="siteDetail">						
							<h2><s:property value="nom"/></h2>					
							<s:param name="id" value="id"/>					
						</s:a>
						<span class="supprimer">
							<s:a action="retirerSiteAuTopo">Retirer
								<s:param name="siteId" value="id"/>
								<s:param name="topoId" value="%{topoId}"/>
							</s:a>						
						</span>

						Localité : <s:property value="codePostal"/> <s:property value="localite"/><br>
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