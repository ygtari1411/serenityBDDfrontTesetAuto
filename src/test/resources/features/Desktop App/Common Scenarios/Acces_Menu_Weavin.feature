# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Accéder au menu Weavin
# Date de création: 27/10/2020



Feature: Connexion_Deconnexion - Acceder au menu weavin

  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0002
  Scenario: Acceder au menu weavin

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté
    And pause 2 secondes
    When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    And pause 2 secondes
    Then vérifier l'affichage correct de tous les sous-menu
    When l utilisateur clique sur "Bouton_fermer_menu_gauche"
    And pause 2 secondes
    Then vérifer la fermeture du sous menu
