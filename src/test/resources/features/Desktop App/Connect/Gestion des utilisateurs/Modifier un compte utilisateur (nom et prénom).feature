# Auteur: BenYedder
# Feature: Gestion des utilisateurs
# Scénario: Modifier un compte utilisateur (nom et prénom)
# Date de création: 02/08/2021

Feature: Gestion des utilisateurs - Modifier un compte utilisateur (nom et prénom)
  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONUTILISATEURS
  @WEAVIN-GESTIONUTILISATEURS-0001
  Scenario: Modifier un compte utilisateur (nom et prénom)

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
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Modifier_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Muhammad Karim" dans le champs "Champ_Input_Prenom_Modifier_utilisateur"
    And pause 5 secondes
    And l utilisateur saisit "Ben nasr" dans le champs "Champ_Input_Nom_Modifier_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_enregistrer_Modifier_utilisateur"
    And pause 10 secondes
    Then vérifier que l utilisateur a été modifié