# Auteur: BenYedder
# Feature: News
# Scénario: Création news sans la publier
# Date de création: 13/01/2021



Feature: News - Création news sans la publier

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0015
  Scenario: Création news sans la publier

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout News

    # When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "Test automatique création news sans la publier" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'une news sans la publier" dans le champs "Champ_Input_Description_News"
    And l utilisitateur saisit la date du jour dans le champs debut date news
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 5 secondes
    And l utilisateur clique sur "Onglet_Liste_Des_News"

 #Etape 3: Verifier news ajoutee avec le statut Brouillon

    When l utilisateur selectionne "Brouillon" dans la liste deroulante "Liste_Deroulante_Statut_News"
    And l utilisateur saisit "Test automatique création news sans la publier" dans le champs "Champ_Input_Rechercher_News_Par_Titre"
    Then Vérifier que seuls les actualités "Brouillon" s'affichent
