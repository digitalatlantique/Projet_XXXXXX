<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Topos</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/topos.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		
		<div class="container">
			
			<h1>Liste des topos</h1>
			
			<s:if test="topos">
				<s:iterator value="topos">	
					<section>
						<s:a action="topoDetail">						
							<h2><s:property value="libelle"/></h2>					
							<s:param name="topoId" value="id"/>					
						</s:a>
						<h3>Information du topo</h3>
						<s:property value="information"/>
						<div class="creer">
							<s:a action="reserverAuthentification">Réserver
								<s:param name="topoId" value="id"/>
							</s:a> 
						</div>

					</section>		
			
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>