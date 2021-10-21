# Auteur: YGtari
# Feature: Article
# Scénario: Ajouter un article
# Date de création: 23/12/2020




Feature: Article - Ajouter un article


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0001
  Scenario: Ajouter un article

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout Article


    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Test automatique création article" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "Article" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un article" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    #And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes


    #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article








