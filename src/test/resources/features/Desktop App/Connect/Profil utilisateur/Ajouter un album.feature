# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter un album
# Date de création: 01/03/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0007
  Scenario: Ajouter un album

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un album

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_photos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_Album"
    And pause 10 secondes
    And l utilisateur saisit "Album Test" dans le champs "Champ_Input_Titre_Album"
    And pause 5 secondes
    And l utilisateur saisit "Ceci est un test automatique de l ajout d un album" dans le champs "Champ_Input_Description_Album"
    And pause 5 secondes
    And l utilisateur upload photo "image2" dans l album' "Photo_attache_nouvel_Album"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    And pause 15 secondes


  #Etape3 : vérifier que l album a été ajouté

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    Then vérifier que l album a été ajouté