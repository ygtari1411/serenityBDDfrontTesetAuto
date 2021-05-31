# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter des loisirs
# Date de création: 11/03/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0013
  Scenario: Ajouter des loisirs

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout d'une loisir

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur saisit "Test loisirs" dans le champs "Champ_Input_Loisirs"
    And pause 5 secondes
    And l utilisateur clique sur Entree pour Loisirs


  #Etape3  vérifier que loisir a été ajouté

    Then vérifier que loisir a été ajouté


