# Auteur: BenYeder
# Feature: Journalisation
# Scénario: Restaurer un article
# Date de création: 15/07/2021


Feature: Journalisation - Restaurer un article

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0005
  Scenario: Restaurer un article

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout Article

    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page knows store
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajout_Article"
    And pause 5 secondes
    Then vérifier que le modal de création d'un article est affiché
    And pause 5 secondes
    And l utilisateur saisit "Test automatique restaurer un article" dans le champs "Champ_Input_Titre_Article"
    And pause 15 secondes
    And l utilisateur selectionne "Article" dans la liste deroulante "categorie_article"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvel_article"
    And l utilisateur saisit "C'est un test automatique de la suppression d'un article" dans le champs "Champ_Input_Description_Article"
    And pause 10 secondes
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvel_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_sauvegarder_article"
    And pause 20 secondes

  #Etape 3 : Vérification de la création de l'article

    Then vérifier la création du nouveau article

  #Etape 4 : Suppresion de l'article

    And l utilisateur clique sur "Bouton_options_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_supprimer_article"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 10 secondes
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 20 secondes

  #Etape 5 : Vérification suppresion correct de la modification

    Then Vérifier que l'article a été supprimé avec succés

  #Etape 6 : Verifier la suppression dans la journalisation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 20 secondes
    Then vérifier que l article supprimé est affiché dans la liste journalisation publications
    And pause 20 secondes

  #Etape 7 : Restaurer l'Article

    And l utilisateur clique sur "Bouton_Restaurer_Element"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page knows store
    And pause 5 secondes
    #Then vérifier la création du nouveau article