# Auteur: ygtari
# Feature: Timeline
# Scénario: Modifier une publication
# Date de création: 11/10/2021



Feature: Timeline - Modification d'une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0006
  Scenario: Modification d'une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé publication statut" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

     #Etape 4 : Modifier la publication

    And l utilisateur clique sur "bouton_option_premiere_publication_afficher"
    And l utilisateur clique sur "bouton_option_Editer_premiere_publication_afficher"
    And l utilisateur modifie "Modification d'une publication" dans le champs "champ_statut_modification"
    And pause 10 secondes
    And l utilisateur clique sur "bouton_publier_statut_modifer"
    #And l utilisateur clique sur "bouton_publier_statut"

    #Etape 5 : Vérifier  la modification de la publication

    Then Vérifier que le statut est modifié