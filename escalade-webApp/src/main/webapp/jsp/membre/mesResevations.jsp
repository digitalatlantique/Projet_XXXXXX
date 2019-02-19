<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes reservations</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<s:head />
	</head>
	
	<body>
	
		<div class="container">
		
			<%@include file="../include/navigation.jsp" %>
	
			<h1>Mes réservations</h1>
				
			<s:if test="#session.mesLocations">
				<s:iterator value="#session.mesLocations">
					<h2>Topo : <s:property value="topo.libelle"/></h2>			
					Date de location : <s:property value="date.getTime()"/><br>
					<s:a action="supprimerReservation">Supprimer
						<s:param name="topoId" value="topo.id"></s:param>
					</s:a>		
				</s:iterator>
			</s:if>
			<s:else>
				Aucun résultat !
			</s:else>		
		</div>
	</body>
</html>