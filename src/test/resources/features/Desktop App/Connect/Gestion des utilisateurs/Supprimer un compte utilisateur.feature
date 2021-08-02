# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Supprimer un compte utilisateur
# Date de création: 02/08/2021

Feature: Gestion des utilisateurs
  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0006
  Scenario: Supprimer un compte utilisateur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
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

  #Etape 3 : Modifier un utilisateur

    And l utilisateur clique sur "invites_utilisateurs"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Remove_Utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And l utilisateur clique sur "Bouton_OK_Suppression_utilisateur"
    #Then vérifier que le utilisateur a été supprimé