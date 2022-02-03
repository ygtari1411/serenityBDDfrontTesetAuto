# Auteur: BenYedder
# Feature: Annuaire
# Scénario: Recherche d'un membre dans annuaire
# Date de création: 10/06/2021

Feature: Annuaire - Recherche d'un membre dans annuaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0003
  Scenario: Recherche d'un membre dans annuaire

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
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

    #Etape 3 : Ajouter un nouvel utilisateur

    And l utilisateur clique sur "Bouton_Ajouter_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "suzanne.aubry@yopmail.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Suzanne" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Aubry" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"

  #Etape 4 : Rechercher l'utilisateur avec nom

    And l utilisateur saisit "Aubry" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté par nom

  #Etape 5 : Rechercher l'utilisateur avec prénom

    And l utilisateur saisit "Suzanne" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté par prénom

  #Etape 6 : Rechercher l'utilisateur avec nom et prénom

    And l utilisateur saisit "Suzanne Aubry" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté par nom et prénom
    And pause 10 secondes
  #Etape 7 : Rechercher l'utilisateur avec prénom erroné

    And l utilisateur saisit "Suuuzanne" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté Prenom erroné