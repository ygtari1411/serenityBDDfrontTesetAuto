# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Déconnexion de l'espace Weavin
# Date de création: 05/01/2021



Feature: Connexion_Deconnexion - Déconnexion de l'espace weavin


  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0003
  Scenario: Déconnexion de l'espace weavin

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 3 secondes
    When l utilisateur effectue un hover sur "Username_menu"
    And pause 1 secondes
    Then Vérifier que le menu s'affiche
    When l utilisateur clique sur "logout_button"
    And pause 3 secondes
    Then vérifier que l'utilisateur est deconnecté