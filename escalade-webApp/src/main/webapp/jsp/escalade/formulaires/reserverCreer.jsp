<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Réserver un topo</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/reserverCreer.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../../include/navigation.jsp" %>
		
		<div class="container">			
			
			<s:actionerror/>
			<div class="formulaire">
				<s:form action="reserverTopo">
					<fieldset>
						<legend>Réserver <s:property value="#session.topo.libelle"/></legend>
						<div class="form-group">
							<s:textfield type="date" name="dateFormulaire" label="Date de location "/>
						</div>
						<s:hidden name="topoId" value="%{topoId}"></s:hidden>
						<s:submit value="Louer" class="btn btn-primary" />					
					</fieldset>	
				</s:form>			
			</div>

			
			<s:if test="#session.locations">
			
				<ul>
					<s:iterator value="#session.locations">
						<li><span class="gras">Réservé le : </span><s:property value="date.getTime()"/> <span class="gras">par </span><s:property value="membre.prenom"/> <s:property value="membre.nom"/></li>
					</s:iterator>				
				</ul>

			
			</s:if>
			<s:else>
				Aucune réservation !
			</s:else>
	
				
		</div>
	</body>
</html>