# Auteur: YGtari
# Feature: News
# Scénario: Rechercher News par statut brouillon
# Date de création: 09/11/2020



Feature: News - Rechercher News par statut brouillon

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0009
  Scenario: Rechercher News par statut brouillon

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News

     #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique de la recherche news par statut brouillon" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de la recherche d 'une news par statut brouillon" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And l utilisateur saisit une heure supérieure à l'heure systéme
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 10 secondes
    And l utilisateur clique sur "Onglet_Liste_Des_News"
    And pause 10 secondes
    And l utilisateur rafraichit la page



    #Etape 3 : Vérification de la création de la News

    Then vérifier la création de la nouvelle news

   #Etape 4 : Rechercher Les news avec le statut Brouillon

    When l utilisateur selectionne "Brouillon" dans la liste deroulante "Liste_Deroulante_Statut_News"
    Then Vérifier que seuls les actualités "Brouillon" s'affichent

