# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Désactiver vimeo
# Date de création: 10/01/2022



Feature: BubbleStore - Desactiver vimeo

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0005
  Scenario: Desactiver vimeo

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Désactiver vimeo

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "app_store"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Configurer_vimeo"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Desactiver_vimeo"

  #Etape3: Verfier que youtube est désactivé

    And l utilisateur clique sur "Bouton_Enregistrer_Configuration_vimeo"
    #todo Configure the channel and take a new dump
    #Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification


