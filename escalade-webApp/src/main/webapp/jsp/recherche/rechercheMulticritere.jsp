<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Escalade-index</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	
	<body>
		<div class="container">
		
			<%@include file="../include/navigation.jsp" %>
			
			<s:actionerror/>
			
			<form action="rechercheMulticritere">
			
				<fieldset class="form-group">
			
					<div class="form-row">
						<div class="col-7">
						  	<s:textfield class="form-control" placeholder="Nom" name="nom" />
						</div>
						<div class="col">
						  	<s:textfield class="form-control" placeholder="Localite" name="localite" />
						</div>
						<div class="col">
						  	<s:textfield class="form-control" placeholder="Cotation" name="cotation" />
						</div>
					</div>
					  <div class="form-group row">
						<div class="col-sm-10">
						  <s:submit class="btn btn-primary" value="Rechercher"/>
						</div>
					  </div>
				  
				  </fieldset>
			</form>
			
		</div>
	</body>
</html>