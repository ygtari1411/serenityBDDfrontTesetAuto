# Auteur: YGtari
# Feature: Bubble Store
# Scénario: Configurer twitter
# Date de création: 14/01/2022



Feature: BubbleStore - Configurer twitter

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BubbleStore
  @WEAVIN-BubbleStore-0008
  Scenario: Configurer twitter

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : configurer vimeo

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "app_store"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Configurer_twitter"
    And pause 10 secondes
    And l utilisateur saisit "Nasser" dans le champs "nom_utilisateur_twitter"
    And pause 10 secondes
    And l utilisateur saisit "12345" dans le champs "cle_consommateur_twitter"
    And pause 10 secondes
    And l utilisateur saisit "12345" dans le champs "cle_securite_twitter"
    And pause 10 secondes
    And l utilisateur saisit "12345" dans le champs "jeton_acces_twitter"
    And pause 10 secondes
    And l utilisateur saisit "12345" dans le champs "jeton_secret_acces_twitter"


  #Etape3: Verifier que a etait effectue avec succes

    And l utilisateur clique sur "Bouton_Enregistrer_Configuration_twitter"
    Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification


