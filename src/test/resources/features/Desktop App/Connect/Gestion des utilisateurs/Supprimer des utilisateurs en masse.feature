# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Supprimer des utilisateurs en masse
# Date de création: 02/08/2021

Feature: Gestion des utilisateurs - Supprimer des utilisateurs en masse
  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0007
  Scenario: Supprimer des utilisateurs en masse

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
    #Etape 3 : Ajouter un nouvel utilisateur

    And l utilisateur clique sur "Bouton_Ajouter_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "zaineb.hamdouch@advyteam.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Zaineb" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Hamdouch" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"
    And pause 10 secondes

  #Etape 3 : Supprimer des utilisateurs en masse

    And l utilisateur clique sur "invites_utilisateurs"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Selectionner_Tous_Utilisateurs"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Remove_Tous_Utilisateurs"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_OK_Suppression_utilisateur"
    #Then vérifier que les utilisateurs ont été supprimés