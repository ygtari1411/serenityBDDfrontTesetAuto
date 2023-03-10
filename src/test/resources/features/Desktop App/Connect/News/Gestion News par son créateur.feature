# Auteur: BenYedder
# Feature: News
# Scénario: Gestion news par son créateur
# Date de création: 19/04/2021

Feature: News - Gestion news par son créateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0018
  Scenario: Gestion news par son créateur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape 2  : Ajout News

    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_fermer_menu_gauche"
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique gestion news par son créateur" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique d un créateur d'actualités ne peut gérer que ses actualités" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_News"
    And pause 20 secondes

  #Etape 3 : Vérification de la création de la News
    And l utilisateur rafraichit la page
    And pause 10 secondes
    Then vérifier la création de la nouvelle news

  #Etape 4 : l'utilisateur admin se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 5 : Le deuxieme utilisateur se connecte  et verifier que news ne s'affiche pas

    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    And pause 10 secondes
    And l utilisateur saisit "Test automatique gestion news par son créateur" dans le champs "Champ_Input_Rechercher_News_Par_Titre"
    #Then Vérifier que l actualité ne s'affiche pas

