# Auteur: BenYedder
# Feature: News
# Scénario: Création nouvelle news avec des champs vides
# Date de création: 13/01/2021



Feature: News

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-NEWS
  @WEAVIN-NEWS-0014
  Scenario: Création nouvelle news avec des champs vides

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout news

    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que le modal de création d'une news est affiché
    And l utilisateur saisit "" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "" dans le champs "Champ_Input_Description_News"
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And vérifier qu un message d'erreur s affiche pour chaque champs requis pour news
    And pause 10 secondes