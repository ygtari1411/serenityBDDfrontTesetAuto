# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter une photo de profile
# Date de création: 23/02/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0001
  Scenario: Ajouter une photo de profile

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout photo de profile

    When l utilisateur clique sur "Username_menu"
    Then vérifier que le profil de l utilisateur est affiché
    And l utilisateur upload photo de profil "image1" dans le champs "H_Upload_photo_de_profil"
    And pause 5 secondes
    Then vérifier que l'image est ajoutée
