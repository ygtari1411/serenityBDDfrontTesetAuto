# Auteur: YGtari
# Feature: News
# Scénario: Rechercher News par statut publié
# Date de création: 09/11/2020


#@WEAVIN
#@WEAVIN-CONNECT
#@WEAVIN-NEWS
#@WEAVIN-NEWS-0007

Feature: News

  Scenario: Rechercher News par statut publié

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

  #Etape2  : Ajout News

    When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news
    And l utilisateur clique sur "Bouton_Ajout_News"
    Then vérifier que la page affichée est la page annoncez une actualité
    And l utilisateur saisit "Test automatique rechercher news par statut" dans le champs "Champ_Input_Titre_News"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'une news" dans le champs "Champ_Input_Description_News"
    And l utilisateur saisit "09/11/2020" dans le champs "Champ_Input_Date_News"
    And  l utilisateur upload "une image" dans le champs "Upload_Image_News"
    And l utilisateur clique sur "Bouton_Enregistrer_Cropper_Picture"
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And l utilisateur clique sur "Bouton_Publier_News"


    #Etape 3 : Vérification de la création de la News

    Then vérifier la création de la nouvelle news

   #Etape 4 : Rechercher Les news avec le statut publié

    When l utilisateur selectionne "Publié" dans la liste deroulante "Liste_Deroulante_Statut_News"
    Then Vérifier que seuls les actualités "Publié" s'affichent







