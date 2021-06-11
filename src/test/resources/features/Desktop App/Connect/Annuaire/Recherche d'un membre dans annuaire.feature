# Auteur: BenYedder
# Feature: Annuaire
# Scénario: Recherche d'un membre dans annuaire
# Date de création: 10/06/2021

Feature: Annuaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0003
  Scenario: Recherche d'un membre dans annuaire

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
    And l utilisateur clique sur "invites_utilisateurs"
    And pause 5 secondes

  #Etape 3 : Rechercher l'utilisateur avec nom

    And l utilisateur saisit "Bennasr" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté

  #Etape 4 : Rechercher l'utilisateur avec prénom

    And l utilisateur saisit "Karim" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté

  #Etape 5 : Rechercher l'utilisateur avec nom et prénom

    And l utilisateur saisit "Karim Bennasr" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    Then vérifier que le nouvel utilisateur a été ajouté

  #Etape 5 : Rechercher l'utilisateur avec prénom erroné

    And l utilisateur saisit "Karimoo" dans le champs "Champ_Input_Chercher_des_membres"
    And l utilisateur clique sur Entree pour le champ recherche
    And pause 10 secondes
    #Then vérifier que le nouvel utilisateur a été ajouté