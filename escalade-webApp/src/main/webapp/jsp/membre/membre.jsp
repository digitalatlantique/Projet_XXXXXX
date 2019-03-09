<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Membre</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="style/membre.css">
	</head>
	
	<body class="container-fluid">
		<%@include file="../include/navigation.jsp" %>
		<div class="container">			
			
			<h1>Bienvenue <s:property value="#session.membre.prenom"/> sur ton espace membre</h1>
			<s:actionmessage/>
			
			<div class="centrer">
			
				<section>
					<h2>Ton espace membre permet</h2>
					<ul>
					
						<li>De laisser des commentaires sur un site.</li>
						<li>De créer un site.</li>
						<li>De creér un topo et de le rendre accessible à la location.</li>
						<li>De louer un topo.</li>
					
					</ul>				
				</section>

			
			</div>
		
		</div>

	</body>

</html>