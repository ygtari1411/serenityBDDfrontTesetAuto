# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Ajouter deux utilisateurs ayant la même adresse mail
# Date de création: 06/08/2021


Feature: Gestion des utilisateurs
  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0009
  Scenario: Ajouter deux utilisateurs ayant la même adresse mail

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
    And l utilisateur saisit "karim.bennasr@yopmail.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Karim" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Bennasr" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"

  #Etape 4 : vérifier que le nouvel utilisateur a été ajouté

    And l utilisateur saisit "Karim" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur "invites_utilisateurs"
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté

  #Etape 5 : Ajouter un nouvel utilisateur avec la meme adresse mail

    And l utilisateur clique sur "Bouton_Ajouter_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "karim.bennasr@yopmail.com" dans le champs "Champ_Input_Email_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Karim" dans le champs "Champ_Input_Prenom_Nouvel_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Ben ahmed" dans le champs "Champ_Input_Nom_Nouvel_utilisateur"
    And pause 5 secondes
    Then l utilisateur clique sur "Bouton_enregistrer_Nouvel_utilisateur"



