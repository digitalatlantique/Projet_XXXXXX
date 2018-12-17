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
		
			<s:form action="recherche">
				 <fieldset class="form-group">
					<div class="row">
			
					  <div class="form-check">
					  	<s:radio label="Critère " name="choixCritere" list="criteres" value="defaultCritere"> </s:radio>					
					  </div>
					</div>
				  </fieldset>
			
				  <div class="form-group row">
					<div class="col-sm-10">
					  <s:textfield class="form-control" name="saisie" requiredLabel="true" />
					</div>
				  </div>
			
				  <div class="form-group row">
					<div class="col-sm-10">
					  <s:submit class="btn btn-primary" value="Rechercher"/>
					</div>
				  </div>
			</s:form>
			
			<s:a action="afficheRechercheMulticritere" >Recherche multicritère</s:a>

		</div>
	</body>
</html>