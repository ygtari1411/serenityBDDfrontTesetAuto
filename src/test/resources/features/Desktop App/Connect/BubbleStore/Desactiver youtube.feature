# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Désactiver youtube
# Date de création: 10/01/2022



Feature: BubbleStore - Desactiver youtube

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0006
  Scenario: Desactiver youtube

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Désactiver youtube

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "app_store"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Configurer_youtube"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Desactiver_youtube"

  #Etape3: Verfier que youtube est désactivé

    And l utilisateur clique sur "Bouton_Enregistrer_Configuration_youtube"
    #todo Configure the channel and take a new dump
    #Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification


