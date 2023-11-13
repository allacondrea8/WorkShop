# Workshop - Gestion d'Ateliers

Ce projet est une application Spring Boot qui gère les inscriptions à différents ateliers de formation. Les utilisateurs peuvent s'inscrire à des ateliers, gérer leurs réservations et visualiser les détails des ateliers disponibles.

## Fonctionnalités

- Inscription des participants à des ateliers.
- Gestion des ateliers par les artisans (création, modification, suppression).
- Affichage des détails des ateliers disponibles.
- Gestion des réservations (confirmation, annulation).

## Technologies Utilisées

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

## Configuration Requise

- Java 17
- Maven 3.9.4
- MySQL 8.0 (ou version supérieure)

## Installation et Démarrage

### Base de Données

Créez une base de données MySQL appelée `workshop_db` et configurez vos identifiants dans le fichier `src/main/resources/application.properties`.

### Lancer l'Application

Pour lancer l'application, exécutez la commande suivante dans le répertoire racine du projet :
mvn spring-boot:run


L'application sera accessible à l'adresse `http://localhost:8080`.

## Structure du Projet

Structure du Projet Workshop
1. src/main/java
Contient les fichiers source de l'application.

Package com.workshop.Workshop.Spring.Boot.MVC

WorkshopSpringBootMvcApplication.java: Classe principale qui lance l'application Spring Boot.
Package com.workshop.Workshop.Spring.Boot.MVC.Controller

Contient les contrôleurs qui gèrent les requêtes HTTP.
ReservationController.java: Gère les requêtes liées aux réservations d'ateliers.
AtelierController.java: (Si présent) Gère les requêtes liées à la gestion des ateliers.
Package com.workshop.Workshop.Spring.Boot.MVC.Models

Contient les classes du modèle qui représentent les entités (tables de la base de données).
Reservation.java, Atelier.java, Participant.java, etc.
Package com.workshop.Workshop.Spring.Boot.MVC.Repository

Contient les interfaces de répertoire pour l'interaction avec la base de données.
ReservationRepository.java, AtelierRepository.java, etc.
Package com.workshop.Workshop.Spring.Boot.MVC.Service

Contient les classes de service qui implémentent la logique métier.
ReservationService.java, AtelierService.java, etc.
2. src/main/resources
Contient les ressources de l'application.

application.properties ou application.yml

Fichier de configuration pour les paramètres de l'application, tels que les données de la base de données et d'autres configurations Spring Boot.
Dossier templates

Contient les templates Thymeleaf pour les vues de l'application.
Fichiers HTML tels que reservation_liste.html, edit_reservation.html, etc.
Dossier static

Contient les fichiers statiques comme les feuilles de style CSS, les scripts JavaScript et les images.
3. src/test/java
Contient les tests de l'application.

Tests unitaires et d'intégration
Classes de test pour tester les différentes composantes de l'application.
Notes Complémentaires
Dépendances Maven (pom.xml)

Configure les dépendances requises pour le projet, y compris Spring Boot starters, les pilotes de base de données, etc.
ServletInitializer.java (Si présent dans un projet WAR)

Fournit la configuration nécessaire pour déployer l'application sous forme de fichier WAR.



## Contact

Alla Condrea : www.linkedin.com/in/allacondrea


