<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Mes reservations</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/mesReservations.css">
		<s:head />
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		<div class="container">			
	
			<h1>Mes réservations</h1>			
			<section>
				<s:if test="#session.mesLocations">
					<s:iterator value="#session.mesLocations">
						<h2>Topo : <s:property value="topo.libelle"/></h2>			
						<span class="gras">Date de location : </span><s:property value="date.getTime()"/><br>
						<span class="supprimer">
							<s:a action="supprimerReservation">Supprimer
								<s:param name="topoId" value="topo.id"></s:param>
							</s:a>							
						</span>	
					</s:iterator>
				</s:if>
				<s:else>
					Aucun résultat !
				</s:else>			
			</section>			
		</div>
	</body>
</html>