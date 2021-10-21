# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Rechercher un utilisateur
# Date de création: 02/08/2021

Feature: Gestion des utilisateurs - Rechercher un utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0008
  Scenario: Rechercher un utilisateur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

  #Etape 2 : Accéder au rubrique Gestion utilisateurs

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_utilisateurs"
    And pause 5 secondes
    Then vérifier que le modal de Gestion des comptes est affiché
    And pause 5 secondes
    And l utilisateur clique sur "invites_utilisateurs"
    And pause 5 secondes

  #Etape 4 : Rechercher utilisateur

    And l utilisateur saisit "Karim" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "Ben" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "ari" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "bennsar" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "BENASR" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes


