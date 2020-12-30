# Auteur: ygtari
# Feature: Idéation
# Scénario: Rechercher idée par titre
# Date de création: 27/12/2020



Feature: Idéation

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-IDEATION
  @WEAVIN-IDEATION-0009
  Scenario: Rechercher idée par titre

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

    #Etape2  : Ajout idée

    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    Then vérifier que la page affichée est la page idéation
    And l utilisateur clique sur "Buton_ajout_ideation"
    Then vérifier que le modal de création d'une idée est affiché
    When l utilisateur saisit "Rechercher idéation par titre" dans le champs "Titre_nouvelle_idee"
    And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
    And l utilisateur saisit "Ceci est la description de l'idée publiée par un test auto" dans le champs "Description_nouvelle_idee"
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification
    And pause 3 secondes

     #Etape 3 : Vérification de la création de l'idée

    Then vérifier la publication correct de l idee

    #Etape 4 : Rechercher idéation par titre

    When l utilisateur saisit "Rechercher idéation par titre" dans le champs "Champ_Input_Rechercher_Ideation_Par_Titre"
    And pause 10 secondes
    Then vérifier que l idée afficher est l'idée recherchée