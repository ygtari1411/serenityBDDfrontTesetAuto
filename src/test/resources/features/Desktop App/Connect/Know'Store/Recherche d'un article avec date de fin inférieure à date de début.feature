# Auteur: BenYedder
# Feature: Article
# Scénario: Recherche d'un article avec date de fin inférieure à date de début
# Date de création: 10/06/2020

Feature: Article - Recherche d'un article avec date de fin inférieure à date de début


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0015
  Scenario: Recherche d'un article avec date de fin inférieure à date de début

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout Article


    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Recherche d'un article avec date de fin inférieure à date de début" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "Article" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique de recherche d'un article avec date de fin inférieure à date de début" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    #And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes


    #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article
    And pause 10 secondes


    #Etape 4 : Recherche d'un article avec date de fin inférieure à date de début

    When l utilisateur clique sur "Calendrier_recherche_article_par_date_debut"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And pause 7 secondes
    And l utilisateur saisit "01/01/2019" dans le champs "Champ_Input_Calendrier_article_par_date_Fin"
    And pause 7 secondes

    #Etape 5 : Vérifier que l'article rechercher s'affiche


    #Then verifier que pas d article rechercher a afficher par date de fin inférieure à date de début






