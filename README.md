# Projet N°6 du parcours développeur d'applications Java (OpenClassrooms)

## Auteur : *Mickaël L*

## Avancement du projet
Le projet est disponible en version 1.0

## Description
Application web permettant d'échanger autour des sites d'escalade et de réserver un topo.

## Configuration de la base de donnée
Dans le module escalade du projet fichier pom.xml.  
Configurer les propriétés avec les valeurs de votre configuration de base de données.
* <jdbc.driver>*Votre driver*</jdbc.driver>
* <jdbc.url>*Votre url*</jdbc.url>
* <jdbc.user>*votre user*</jdbc.user>
* <jdbc.pass>*votre_pass*</jdbc.pass> 
 
#### Disponible dans escalade/assets/sql      
* Dump de la base de donnée 
* Jeu d'essai  
* Modèle physique de données

## Pour déployer l'application
Dans le module escalade du projet  
mvn package -P prod

Pour déployer l'application dans tomcat, récuperer le war générer dans escalade-webApp/target/escalade-webApp.war
