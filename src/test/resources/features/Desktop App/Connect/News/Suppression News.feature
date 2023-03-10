# Auteur: YGtari
# Feature: News
# Scénario: Suppression News
# Date de création: 09/11/2020



Feature: News - Suppression news

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0005
  Scenario: Suppression news

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News


    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique suppression news" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de la suppression d'une news" dans le champs "Champ_Input_Description_News"
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


  #Etape 4 : Suppression News


    And l utilisateur clique sur "Bouton_Options_Premiere_News_Afficher"
    And l utilisateur clique sur "Bouton_Supprimer_News"
    And pause 5 secondes


  #Etape 5 : Vérification de la suppression

    And l utilisateur clique sur "Bouton_confirmer_action"
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 10 secondes
    Then Vérifier que l'actualité a été spprimer avec succés


