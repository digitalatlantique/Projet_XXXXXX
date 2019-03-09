<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

	<div class="collapse navbar-collapse" id="navbarNav">	
		<ul class="navbar-nav">
			<!-- Session public -->
			<li class="nav-item">
				<s:a class="nav-link" action="index">Home</s:a>
			</li>
			<li class="nav-item">
			  <s:a class="nav-link" action="membre">Membre</s:a>
			</li>
			
			<li class="nav-item">
				<s:a class="nav-link" action="topo">Topos</s:a>
			</li>
			
			<li class="nav-item">
				<s:a class="nav-link" action="recherche">Rechercher</s:a>
			</li>	
		</ul>
	 </div>

    <!-- Session membre -->
	<s:if test="#session.membre">
	<div class="collapse navbar-collapse justify-content-end" id="navbarCollapse">
		<ul class="navbar-nav ">
			<li class="nav-item">
			  	<s:a class="nav-link" action="mesSites">Mes sites</s:a>
			</li>
			<li>
				<s:a class="nav-link" action="mesTopos">Mes topos</s:a>
			</li>
			<li>
				<s:a class="nav-link" action="mesReservations">Mes réservations</s:a>
			</li>
			<li class="nav-item">
			  	<s:a class="nav-link" action="deconnexion">Déconnexion</s:a>
			</li>
		</ul> 
	</div> 	
	</s:if> 
</nav>
