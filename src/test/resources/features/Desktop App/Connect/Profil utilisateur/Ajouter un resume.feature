# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Ajouter un resume
# Date de création: 25/01/2022

Feature: Profil utilisateur - Ajouter un resume

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0024
  Scenario: Ajouter un resume

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "ceci est un test automatique de l ajout d un resume" dans le champs "Champ_Input_Profil_resume"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"


  #Etape3  vérifier que le resumé a été ajouter

    Then vérifier que le message "Mise à jour des informations de profil !" s'affiche dans la notification


