<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Recherche multicritère</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/rechercheMulticritere.css">
	</head>
	
	<body class="container-fluid">
	
		<%@include file="../include/navigation.jsp" %>
		<div class="container">			
			
			<div class="formulaire">
			
				<div>
					<s:actionerror/>
			
					<form action="rechercheMulticritere">
					
						<fieldset class="form-group">
					
							<div class="row">
								<div class="col-sm-12">
								  	<s:textfield class="form-control" placeholder="Nom" name="nom" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
								  	<s:textfield class="form-control" placeholder="Localite" name="localite" />
								</div>						
							</div>
							<div class="row">
								<div class="col-sm-12">
								  	<s:textfield class="form-control" placeholder="Cotation" name="cotation" />
								</div>	
							</div>

							  <div class="row">
								<div class="col-sm-12">
								  <s:submit class="btn btn-primary" value="Rechercher"/>
								</div>
							  </div>
						  
						  </fieldset>
					</form>
				</div>
			
			</div>

			
		</div>
	</body>
</html>