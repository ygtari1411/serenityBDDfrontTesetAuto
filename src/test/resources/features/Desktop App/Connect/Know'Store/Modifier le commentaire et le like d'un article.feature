# Auteur: YGtari
# Feature: Article
# Scénario: Modifier le commentaire et le like d'un article
# Date de création: 29/12/2020




Feature: Article

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0005
  Scenario: Modifier le commentaire et le like d'un article

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout Article

    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Test automatique modifier commentaire et like d'un article" dans le champs "Champ_Input_Titre_Article"
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

    #Etape 4 : l'utilisateur admin se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

    #Etape 5 : Le deuxieme utilisateur   se connecte  pour liker et commenter l'article

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 10 secondes
    And l utilisateur clique sur "Premier_Article_Afficher_Utilisateur"
    And l utilisateur saisit "Commenter et liker un article" dans le champs "Champ_Input_Commenter_Article"
    And l utilisateur clique sur "Envoyer_Commenteraire_Article"
    Then vérifier que le commentaire a été ajouté
    When l utilisateur effectue un hover sur "Bouton_Interaction_Article"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_Like_Article"
    And pause 15 secondes
    Then vérifier  que le like  a été ajouté
    And pause 10 secondes

   #Etape 6 : modifier le commentaire

    When l utilisateur effectue un hover sur "Bouton_Option_Commentaire_Ideation"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Editer_Commentaire_Article"
    And pause 15 secondes
    And l utilisateur modifie "commentaire modifiée" dans le champs "Champ_Input_Modification_Commenteraire_Article"
    And pause 5 secondes
    #And l utilisateur clique sur "Envoyer_Commenteraire_Modifier_Article"
    And l utilisateur clique sur le bouton Envoyer_Commenteraire_Modifier_Article
    And pause 15 secondes
    Then verifier que le commentaire de l article est modifié

   #Etape 7 : modifier l'interaction

    When l utilisateur effectue un hover sur "Bouton_Interaction_Article"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_Praise_Article"
    And pause 15 secondes
    Then verifier que l interaction de l article a été modifiée avec succés








