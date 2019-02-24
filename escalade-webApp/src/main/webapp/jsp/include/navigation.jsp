<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
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
      <!-- Session membre -->
      <s:if test="#session.membre">
	      <li class="nav-item">
	        <s:a class="nav-link" action="mesSites">Mes sites</s:a>
	      </li>
	      <li>
	      	<s:a class="nav-link" action="mesTopos">Mes topos</s:a>
	      </li>
	      <li>
	      	<s:a class="nav-link" action="mesReservations">Mes r�servations</s:a>
	      </li>
	      <li class="nav-item">
	        <s:a class="nav-link" action="deconnexion">D�connexion</s:a>
	      </li>

      </s:if>
      

    </ul>
  </div>
</nav>
