# Auteur: YGtari
# Feature: Article
# Scénario: Commenter et Liker un article
# Date de création: 28/12/2020


@WEAVIN
@WEAVIN-CONNECT
@WEAVIN-KnowStore
@WEAVIN-KnowStore-0004

Feature: Article

  Scenario: Commenter et Liker un article

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

  #Etape2  : Ajout Article


    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Test automatique commenter et liker un article" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "category 1" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un article" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes


    #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article

    #Etape 4 : l'utilisateur admin se deconnecte

     And  l utilisateur se deconnecte

    #Etape 4 : Le deuxieme utilisateur   se connecte  pour liker et commenter l'article

    When l'utilisateur "josephine.berard@yopmail.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 10 secondes
    And l utilisateur saisit "Test automatique commenter et liker un article" dans le champs "Champ_Input_Rechercher_Article_Par_Titre"
    And pause 15 secondes
    And l utilisateur clique sur "Titre_Premier_Article_publier"
    And l utilisateur saisit "Commenter et liker un article" dans le champs "Champ_Input_Commenter_Article"
    And l utilisateur clique sur "Envoyer_Commenteraire_Article"
    Then vérifier que le commentaire a été ajouté













