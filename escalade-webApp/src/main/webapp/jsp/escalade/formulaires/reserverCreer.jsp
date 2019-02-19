<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Réserver un topo</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

	</head>
	
	<body>
	
		<div class="container">
						
			<%@include file="../../include/navigation.jsp" %>

			<h1>Réserver</h1>
			
			<s:actionerror/>
			
			<s:form action="reserverTopo">
				<div class="form-group">
					<s:textfield type="date" name="dateFormulaire" label="Date de location "/>
				</div>
				<s:hidden name="topoId" value="%{topoId}"></s:hidden>
				<s:submit value="Louer" class="btn btn-primary" />
			</s:form>	
				
		</div>
	</body>
</html>