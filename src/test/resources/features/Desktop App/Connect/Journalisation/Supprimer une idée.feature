# Auteur: BenYeder
# Feature: Journalisation
# Scénario: Supprimer une idée
# Date de création: 01/04/2021


Feature: Journalisation - Supprimer une idée

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0003
  Scenario: Supprimer une idée

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

  #Etape2  : Ajout idée

    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page idéation
    And pause 5 secondes
    When l utilisateur clique sur "Buton_ajout_ideation"
    And pause 5 secondes
    Then vérifier que le modal de création d'une idée est affiché
    And pause 5 secondes
    When l utilisateur saisit "test automatisé suppression d'une idée - Journalisation" dans le champs "Titre_nouvelle_idee"
    And pause 5 secondes
    And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
    And pause 5 secondes
    And l utilisateur saisit "Ceci est un test de publication d'une idée qui va étre supprimée" dans le champs "Description_nouvelle_idee"
    And pause 10 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification
    And pause 5 secondes

  #Etape 3 : Vérification de la création de l'idée

    Then vérifier la publication correct de l idee
    And pause 5 secondes

  #Etape 4 : Suppresion de l'article

    When l utilisateur saisit "test automatisé suppression d'une idée - Journalisation" dans le champs "Champ_Input_Rechercher_Ideation_Par_Titre"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_option_derniere_ideation"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_ideation"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 10 secondes


  #Etape 5 : Verifier la suppression dans la journalisation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 20 secondes
    Then vérifier que l idée supprimé est affiché dans la liste journalisation publications
