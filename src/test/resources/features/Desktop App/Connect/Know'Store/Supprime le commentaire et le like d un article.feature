# Auteur: YGtari
# Feature: Article
# Scénario: Supprimer le commentaire et le like d'un article
# Date de création: 13/01/2021




Feature: Article - Supprimer le commentaire et le like d'un article

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0006
  Scenario: Supprimer le commentaire et le like d'un article

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout Article

    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Test automatique supprimer le commentaire et le like d'un article" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "Article" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique de la suppression du commentaire et du like d'un article" dans le champs "Champ_Input_Description_Article"
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


   #Etape 7 : le deuxieme utilisateur  supprime le like

    And l utilisateur clique sur "Bouton_Like_Article_Down_Page"
    And pause 20 secondes


  #Etape 8 : Le deuxieme utilisateur supprime le commentaire

    When l utilisateur effectue un hover sur "Bouton_Option_Commentaire_Ideation"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Editer_Supprimer_Article"
    And pause 15 secondes

  #Etape 9 : Vérifier que le commentaire et le like ont été supprimé

   Then verifier que le like a été supprimé
   And  verifier que le commentaire a été supprimé










