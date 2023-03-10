# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter un auteur
# Date de création: 25/02/2021

Feature: Profil utilisateur - Ajouter un auteur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0006
  Scenario: Ajouter un auteur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un auteur

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "ceci est un test automatique de l ajout d une citation avec auteur" dans le champs "Champ_Input_Profil_Citation"
    And pause 10 secondes
    And l utilisateur saisit "Auteur Test" dans le champs "Champ_Input_Profil_Auteur"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape3  vérifier que la citation a été ajouté

    #Then vérifier que l auteur a été ajouté


