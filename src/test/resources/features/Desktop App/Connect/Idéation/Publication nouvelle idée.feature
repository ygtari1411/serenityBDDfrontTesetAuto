# Auteur: wboufade
# Feature: Idéation
# Scénario: Ajout d'une nouvelle idée
# Date de création: 03/11/2020



Feature: Idéation - Ajout d'une nouvelle idée

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-IDEATION
  @WEAVIN-IDEATION-0001
  Scenario: Ajout d'une nouvelle idée

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page idéation
    And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
    And pause 5 secondes
    When l utilisateur clique sur "Buton_ajout_ideation"
    Then vérifier que le modal de création d'une idée est affiché
    When l utilisateur saisit "test automatisé publication nouvelle idée" dans le champs "Titre_nouvelle_idee"
    And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
    And l utilisateur saisit "Ceci est la description de l'idée publiée par un test auto" dans le champs "Description_nouvelle_idee"
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification
    And pause 3 secondes
    Then vérifier la publication correct de l idee