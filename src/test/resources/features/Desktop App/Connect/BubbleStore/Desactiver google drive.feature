# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Désactiver google drive
# Date de création: 11/01/2022



Feature: BubbleStore - Desactiver google drive

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0003
  Scenario: Desactiver google drive

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Désactiver google drive

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "app_store"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Configurer_google_drive"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Desactiver_google_drive"

  #Etape3: Verfier que youtube est désactivé

    And l utilisateur clique sur "Bouton_Enregistrer_Configuration_one_drive"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification


