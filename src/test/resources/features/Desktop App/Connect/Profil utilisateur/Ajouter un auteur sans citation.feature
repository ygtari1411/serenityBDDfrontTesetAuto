# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter un auteur sans citation
# Date de création: 20/04/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0017
  Scenario: Ajouter un auteur sans citation

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un auteur sans citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "ceci est un test automatique de l ajout d un auteur sans citation" dans le champs "Champ_Input_Profil_Citation"
    And pause 5 secondes
    And l utilisateur saisit "Auteur Test" dans le champs "Champ_Input_Profil_Auteur"
    And pause 5 secondes
    And l utilisateur modifie "" dans le champs "Champ_Input_Profil_Citation"
    And pause 10 secondes
    And l utilisateur valide citation vide
    And pause 10 secondes
    Then vérifier que l input auteur ne s affiche pas


