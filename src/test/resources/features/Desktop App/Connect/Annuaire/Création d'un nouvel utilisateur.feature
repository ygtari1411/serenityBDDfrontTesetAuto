# Auteur: BenYedder
# Feature: Annuaire
# Scénario: Création d'un nouvel utilisateur
# Date de création: 16/03/2021

Feature: Annuaire - Création d'un nouvel utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0001
  Scenario: Création d'un nouvel utilisateur

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

  #Etape 3 : Ajouter un nouvel utilisateur

    And l utilisateur clique sur "Bouton_Ajouter_Nouvel_utilisateur"
    And pause 5 secondes
    #And l utilisateur saisit "zaineb.hamdouch@advyteam.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Zaineb" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Hamdouch" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"
    And pause 20 secondes

  #Etape 4 : vérifier que le nouvel utilisateur a été ajouté

    And l utilisateur clique sur "invites_utilisateurs"
    And pause 10 secondes
    And l utilisateur saisit "zaineb" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 20 secondes
    Then vérifier que le nouvel utilisateur a été ajouté




