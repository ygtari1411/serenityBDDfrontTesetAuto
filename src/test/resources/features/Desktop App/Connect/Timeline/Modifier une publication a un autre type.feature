# Auteur: ygtari
# Feature: Timeline
# Scénario: Modifier une publication a un autre type
# Date de création: 26/10/2021



Feature: Timeline - Modifier une publication a un autre type

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0007
  Scenario: Modifier une publication a un autre type

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
    And l utilisateur modifie "" dans le champs "champ_statut_modification"
    And l utilisateur change le format de publication
    And pause 10 secondes
    And l utilisateur clique sur "bouton_publier_statut_modiferr"

    #Etape 5 : Vérifier  la modification de la publication

    Then Vérifier que le statut est modifié