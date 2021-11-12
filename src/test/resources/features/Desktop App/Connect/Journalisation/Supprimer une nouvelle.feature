# Auteur : BenYedder
# Feature : Journalisation
# Scénario : Supprimer une nouvelle
# Date de création : 19/11/2021

Feature: Journalisation - Supprimer une nouvelle

  @WEAVIN
  @WEVAIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0011

  Scenario: Supprimer une nouvelle


  # Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 20 secondes

  # Etape 2 : Ajout News

    When l utilisateur clique sur "Bouton_news_menu_gauche"
    And pause 3 secondes
    Then vérifier que la page affichée est la page news
    And pause 3 secondes
    And l utilisateur clique sur "Bouton_Ajout_News"
    And pause 3 secondes
    Then vérifier que le modal de création d'une news est affiché
    And pause 3 secondes
    And l utilisateur saisit "Test automatique suppression news" dans le champs "Champ_Input_Titre_News"
    And pause 3 secondes
    And l utilisateur saisit "C'est un test automatique de la suppression d'une news" dans le champs "Champ_Input_Description_News"
    And pause 3 secondes
    And l utilisateur upload "image1" dans le champs "H_upload_photo_nouvelle_news"
    And pause 3 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
    And pause 3 secondes
    And l utilisateur clique sur "Bouton_Publier_News"
    And pause 3 secondes
    Then vérifier la création de la nouvelle news

  # Etape 3 : Suppression News

    And l utilisateur clique sur "Bouton_Options_Premiere_News_Afficher"
    And l utilisateur clique sur "Bouton_Supprimer_News"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 10 secondes
    Then Vérifier que l'actualité a été spprimer avec succés

  # Etape 4 : Verification | Suppression dans la journalisation
  
    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 5 secondes
    Then vérifier que la nouvelle supprimée est affiché dans la liste journalisation publications
