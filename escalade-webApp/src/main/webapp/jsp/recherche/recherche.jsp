<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Recherche</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/recherche.css">
	</head>
	
	<body class="container-fluid">
		<%@include file="../include/navigation.jsp" %>
		<div class="container">	
		
			<div class="formulaire">
			
				<div>
					<s:actionerror/>
				
					<s:form action="recherche">
						 
						<div class="row">				
							<div class="form-check">
								<s:radio name="choixCritere" list="criteres" value="defaultCritere"> </s:radio>					
							 </div>
						</div>					  
						
						<div class="row">
							<div class="col-sm-12">			
							  	<s:textfield class="form-control" id="inputdefault" name="saisie" placeholder="Votre mot clé" requiredLabel="true" />
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-10">
							  	<s:submit class="btn btn-primary" value="Rechercher"/>
							</div>
						 </div>					  
						
					</s:form>
					<s:a action="afficheRechercheMulticritere" >Recherche multicritère</s:a>
				</div>			
			
			</div>		


		</div>
	</body>
</html>