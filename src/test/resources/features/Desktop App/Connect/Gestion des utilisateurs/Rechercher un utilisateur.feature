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
#Etape 3 : Ajouter un nouvel utilisateur

    And l utilisateur clique sur "Bouton_Ajouter_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "ghada.ayadi@advyteam.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Ghada" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "AYADI" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"
    And pause 10 secondes

  #Etape 4 : Rechercher utilisateur

    And l utilisateur saisit "ghada" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "Gha" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "AYA" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "ayadi" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

    And l utilisateur saisit "AYADI" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 5 secondes
    Then vérifier que le nouvel utilisateur a été ajouté
    And pause 5 secondes

     #Etape 5 : Supprimer  un utilisateur

    And l utilisateur clique sur "invites_utilisateurs"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Remove_Utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And l utilisateur clique sur "Bouton_OK_Suppression_utilisateur"

     #Etape 7 : Rechercher l'utilisateur avec prénom erroné

    And l utilisateur saisit "Ghaaaaada" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté Prenom erroné


