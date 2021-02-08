# Auteur: BenYedder
# Feature: Article
# Scénario: Recherche d'un article par date de début et date de fin
# Date de création: 02/02/2020




Feature: Article


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0011
  Scenario: Recherche d'un article par date de début et date de fin

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

  #Etape2  : Ajout Article


    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "Rechercher par date de début et date de fin" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "Catégorie 1" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique recherche d'un article par date de début et date de fin" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes


    #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article
    And pause 10 secondes


    #Etape 4 : Rechercher article par date de début et date de fin

    When l utilisateur clique sur "Calendrier_recherche_article_par_date_debut"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And pause 7 secondes
    And l utilisateur clique sur "Calendrier_recherche_article_par_date_Fin"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And pause 7 secondes

    #Etape 5 : Vérifier que l'article rechercher s'affiche


    Then verifier que l article rechercher par date de debut et date de fin s affiche






