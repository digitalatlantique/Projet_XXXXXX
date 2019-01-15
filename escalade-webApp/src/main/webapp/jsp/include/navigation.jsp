<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
      	<s:a class="nav-link" action="index">Home</s:a>
      </li>
      <li class="nav-item">
        <s:a class="nav-link" action="membre">Membre</s:a>
      </li>
      <s:if test="#session.membre">
	      <li class="nav-item">
	        <s:a class="nav-link" action="mesSites">Mes sites</s:a>
	      </li>
	      <li class="nav-item">
	        <s:a class="nav-link" action="deconnexion">Déconnexion</s:a>
	      </li>

      </s:if>

      <li class="nav-item">
      	<s:a class="nav-link" action="recherche">Rechercher</s:a>
      </li>
    </ul>
  </div>
</nav>
