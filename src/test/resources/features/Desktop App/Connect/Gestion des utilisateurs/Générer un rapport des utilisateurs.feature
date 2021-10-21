# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Générer un rapport des utilisateurs
# Date de création: 06/08/2021

Feature: Gestion des utilisateurs - Générer un rapport des utilisateurs
  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0010
  Scenario: Générer un rapport des utilisateurs

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

  #Etape 3 : Générer un rapport des utilisateurs

    And l utilisateur clique sur "Bouton_Selectionner_Tous_Utilisateurs_actifs"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Rapport_Utilisateurs"