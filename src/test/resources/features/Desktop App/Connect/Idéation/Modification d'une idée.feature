# Auteur: wboufade
# Feature: Idéation
# Scénario: Modification d'une idée
# Date de création: 06/11/2020




Feature: Idéation - Modification d'une idée

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-IDEATION
  @WEAVIN-IDEATION-0002
  Scenario: Modification d'une idée

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    Then vérifier que la page affichée est la page idéation
    When l utilisateur clique sur "Buton_ajout_ideation"
    Then vérifier que le modal de création d'une idée est affiché
    When l utilisateur saisit "test automatisé publication et modification d'une idée" dans le champs "Titre_nouvelle_idee"
    And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
    And l utilisateur saisit "Ceci est un test de publication d'une idée qui va etre modifiée" dans le champs "Description_nouvelle_idee"
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification
    And pause 3 secondes
    Then vérifier la publication correct de l idee
    When l utilisateur clique sur "Calendrier_recherche_publication_par_date"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And pause 7 secondes
    And l utilisateur clique sur "Bouton_option_derniere_ideation"
    And pause 3 secondes
    And l utilisateur clique sur "Bouton_modifier_ideation"
    And l utilisateur modifie "Ceci est la modification de l'idéation" dans le champs "Titre_nouvelle_idee"
    And l utilisateur modifie "Description modifiée" dans le champs "Description_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification