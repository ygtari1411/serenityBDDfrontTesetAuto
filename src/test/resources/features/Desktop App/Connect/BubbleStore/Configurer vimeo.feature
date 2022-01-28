# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Configurer vimeo
# Date de création: 14/01/2022



Feature: BubbleStore - Configurer vimeo

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0007
  Scenario: Configurer vimeo

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : configurer vimeo

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "app_store"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Configurer_vimeo"
    And pause 10 secondes
    And l utilisateur selectionne "Utilisateur" dans la liste deroulante "Liste_Deroulante_vimeo_TypeSource"
    And pause 10 secondes
    And l utilisateur saisit "87e96b5bae865fc35fda5472434cef131ca72d2e" dans le champs "chaine_id_vimeo"
    And pause 10 secondes
    And l utilisateur saisit "https://api.vimeo.com/oauth/access_token" dans le champs "Champs_Token"
    And pause 10 secondes
    And l utilisateur saisit "3" dans le champs "nombre_video_afficher_vimeo"


  #Etape3: Verifier que a etait effectue avec succes

    And l utilisateur clique sur "Bouton_Enregistrer_Configuration_vimeo"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification


