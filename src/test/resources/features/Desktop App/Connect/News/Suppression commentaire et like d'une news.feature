# Auteur: BenYedder
# Feature: News
# Scénario: Suppression commentaire et like d'une news
# Date de création: 19/01/2021



Feature: News - Suppression commentaire et like d'une news

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0017
  Scenario: Suppression commentaire et like d'une news

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News

    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique supprimer commentaire et like d'une news" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique supprimer commentaire et like d'une news" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_News"
    And pause 10 secondes

  #Etape 3 : Vérification de la création de la News
    And l utilisateur rafraichit la page
    And pause 4 secondes
    Then vérifier la création de la nouvelle news
    And pause 10 secondes

  #Etape 4 : Commenter une news

    When l utilisateur clique sur "Bouton_accueil_menu_gauche"
    And pause 10 secondes
    And l utilisateur effectue un hover sur "Barre_Temoin_Premiere_News_Affichee_accueil"
    And l utilisateur clique sur "widget_News_Affichee_accueil"
    And l utilisateur clique sur "Titre_derniere_news"
    #And l utilisateur clique sur la derniere news ajoutee
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Repondre_newss"
    And l utilisateur saisit "test automatisé commenter et Liker une news" dans le champs "Champ_Input_Commenter_News"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_Commenteraire_News"
    And l utilisateur clique sur "Bouton_like_newss"
    And pause 10 secondes
    And vérifier l'ajout du commentaire et le like
  #Etape 5 : Liker une news
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_like_newss"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Commentairee"

  #Etape 6 : Supprimer le commentaire

    When l utilisateur effectue un hover sur "Bouton_Option_Commentaire_News"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Commeaire_News"

    #Then verifier que le commentaire news est supprimé // to do

