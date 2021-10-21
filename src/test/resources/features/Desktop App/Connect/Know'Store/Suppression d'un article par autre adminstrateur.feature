# Auteur: BenYedder
# Feature: Article
# Scénario: Suppression d'un article par autre adminstrateur
# Date de création: 19/04/2021

Feature: Article - Suppression d'un article par autre adminstrateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0014
  Scenario: Suppression d'un article par autre adminstrateur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2  : Ajout Article

    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Test automatique suppression d'un article par autre adminstrateur" dans le champs "Champ_Input_Titre_Article"
    And pause 10 secondes
    And l utilisateur selectionne "Article" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And pause 10 secondes
    And l utilisateur saisit "C'est un test automatique d'un administrateur peut supprimer un article d'un autre administrateur" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    #And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes

  #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article

  #Etape 4 : l'utilisateur admin se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 5 : Le deuxieme utilisateur se connecte  et supprimer l'article

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_options_article"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_article_autre_admin"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And l utilisateur clique sur "Bouton_confirmer_action"

  #Etape 6 : Vérification suppresion correct de l'article'

    Then Vérifier que l'article a été supprimé avec succés