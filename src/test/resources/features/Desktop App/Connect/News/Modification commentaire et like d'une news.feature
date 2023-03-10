# Auteur: BenYedder
# Feature: News
# Scénario: Modification commentaire et like d'une news
# Date de création: 15/01/2021



Feature: News - Modification commentaire et like d'une news

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0016
  Scenario: Modification commentaire et like d'une news

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News

    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique modifier commentaire et like d'une news" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique modifier commentaire et like d'une news" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_News"
    And pause 10 secondes

  #Etape 3 : Vérification de la création de la News

    Then vérifier la création de la nouvelle news
    And pause 10 secondes

  #Etape 4 : Commenter une news

    When l utilisateur clique sur "Bouton_accueil_menu_gauche"
    And l utilisateur clique sur la derniere news ajoutee
    And l utilisateur clique sur "Bouton_Repondre_newss"
    And l utilisateur saisit "test automatisé commenter et Liker une news" dans le champs "Champ_Input_Commenter_News"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_Commenteraire_News"

    Then vérifier l ajout  correct du commentaire news

  #Etape 5 : Liker une news

    And l utilisateur clique sur "Bouton_like_newss"
    And pause 20 secondes
    Then vérifier l ajout  correct du Like news

  #Etape 6 : Modifier le commentaire

    When l utilisateur effectue un hover sur "Bouton_Option_Commentaire_News"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Editer_Commentaire_News"
    And pause 10 secondes
    And l utilisateur modifie "commentaire modifiée" dans le champs "Champ_Input_Modification_Commenteraire_News"
    And pause 5 secondes
    And l utilisateur clique sur "Envoyer_Commenteraire_Modifier_News"
    And pause 15 secondes
    Then verifier que le commentaire news est modifié
    And pause 20 secondes

  #Etape 7 : Modifier l'interaction

    When l utilisateur effectue un hover sur "Bouton_Interaction_News"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_Praise_News"
    And pause 10 secondes
    #Then verifier que l'interaction news a été modifiée avec succés