# Auteur: BenYedder
# Feature: Article
# Scénario: Ajouter un article avec des champs vides
# Date de création: 02/02/2021

Feature: Article

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-KnowStore
  @WEAVIN-KnowStore-0012
  Scenario: Ajouter un article avec des champs vides

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout Article avec champs vides

    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    And l utilisateur clique sur "Bouton_Ajout_Article"
    Then vérifier que le modal de création d'un article est affiché
    And l utilisateur saisit "" dans le champs "Champ_Input_Titre_Article"
    And pause 5 secondes
    And l utilisateur selectionne "" dans la liste deroulante "categorie_article"
    And pause 5 secondes
    And l utilisateur saisit "" dans le champs "Champ_Input_Description_Article"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 10 secondes
    And vérifier qu un message d'erreur s affiche pour chaque champs requis pour article
    And pause 10 secondes