# Auteur: ygtari
# Feature: Idéation
# Scénario: Tri des idées : Descendant : Par Note
# Date de création: 22/12/2020


@WEAVIN
@WEAVIN-CONNECT
@WEAVIN-IDEATION
@WEAVIN-IDEATION-0014


Feature: Idéation

  Scenario: Tri des idées : Descendant : Par Note

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

    #Etape2  : Ajout d'une idée

    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    Then vérifier que la page affichée est la page idéation
    And l utilisateur clique sur "Buton_ajout_ideation"
    Then vérifier que le modal de création d'une idée est affiché
    When l utilisateur saisit "Tri des idées : Descendant" dans le champs "Titre_nouvelle_idee"
    And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
    And l utilisateur saisit "Ceci est la description de l'idée publiée par un test auto" dans le champs "Description_nouvelle_idee"
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    Then vérifier que le message "Opération effectuée avec succés" s'affiche dans la notification
    And pause 10 secondes

     #Etape 3 : Vérification de la création de l'idée

    Then vérifier la publication correct de l idee

     #Etape 4 : Trier les idées :Ascendant

    When l utilisateur clique sur "Bouton_Trier_Ideation"
    And pause 10 secondes
    And l utilisateur selectionne "Note" dans la liste deroulante "Liste_Deroulante_Choix_Tri_Ideation"
    And pause 10 secondes
    And l utilisateur selectionne "Descendant" dans la liste deroulante "Liste_Deroulante_Tri_ASC_DES"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Trier_Ideation"
    And pause 5 secondes

     #Etape 5 : Verifer l'affichage des idées :Ascendant

    Then verifier que les idées sont affichées par ordre descendant
