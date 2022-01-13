# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Configurer une  chaine  youtube
# Date de création: 10/01/2022



Feature: BubbleStore - Desactiver youtube

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0001
  Scenario: Configurer une chaine youtube

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

  #Etape3: Suivre les étapes de configuration et verifier que le modal de creation s affiche

    And l utilisateur clique sur "Modal_Configuration_youtube"
    And pause 10 secondes
    Then verifier que le modal d'instruciton de configuration youtube s affiche


