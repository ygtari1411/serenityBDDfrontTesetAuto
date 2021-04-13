# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter des connaissances
# Date de création: 11/03/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0012
  Scenario: Ajouter des connaissances

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté
    And pause 10 secondes

  #Etape2  : Ajout d'une Connaissance

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur saisit "Test Connaissance" dans le champs "Champ_Input_Connaissances"
    And pause 5 secondes
    And l utilisateur clique sur Entree pour Connaissance


  #Etape3  vérifier que  connaissance a été ajouté

    Then vérifier que connaissance a été ajouté


