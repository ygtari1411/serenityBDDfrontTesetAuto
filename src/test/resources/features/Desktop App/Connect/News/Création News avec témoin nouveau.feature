# Auteur: BenYedder
# Feature: News
# Scénario: Création news avec témoin nouveau
# Date de création: 11/01/2021



Feature: News - Création news avec témoin nouveau

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0012
  Scenario: Création news avec témoin nouveau

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News

    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique création news avec témoin nouveau" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'une news avec témoin noveau" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Temoin_Nouveau"
    And pause 10 secondes
    And l utilisateur saisit "5" dans le champs "Champ_Input_Temoin_Nouveau_Duree"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_News"
    And pause 10 secondes

  #Etape 3 : Vérification de la création de la News avec temoin nouveau
    And l utilisateur rafraichit la page
    And pause 4 secondes
    Then vérifier la création de la nouvelle news
    And l utilisateur clique sur "Bouton_accueil_menu_gauche"
    And pause 10 secondes
    And vérifier que le témoin nouveau est affiché

