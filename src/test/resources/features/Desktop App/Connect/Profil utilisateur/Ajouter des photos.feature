# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter des photos
# Date de création: 07/05/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0019
  Scenario: Ajouter des photos

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un album

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_photos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_photos"
    And pause 10 secondes
    And l utilisateur ajoute la photo "image1" dans le champs "Champ_Input_Ajout_photos"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_telecharger_photo"
    And pause 15 secondes


  #Etape3 : vérifier que l album a été ajouté

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    #Then vérifier que la photo a été ajouté