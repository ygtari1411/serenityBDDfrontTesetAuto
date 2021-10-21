# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter un album vide
# Date de création: 05/04/2021

Feature: Profil utilisateur - Ajouter un album vide

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0016
  Scenario: Ajouter un album vide

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un album vide

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_photos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_Album"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    Then vérifier que le message "Le titre de l'album est un champs obligatoire" s'affiche dans la notification
