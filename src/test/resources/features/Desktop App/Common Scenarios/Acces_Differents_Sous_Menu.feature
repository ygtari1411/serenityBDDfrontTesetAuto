# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Accéder aux différents sous menu
# Date de création: 05/01/2021



Feature: Connexion_Deconnexion - Accéder aux différents sous menu


  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0005
  Scenario: Accéder aux différents sous menu

    Given le navigateur est ouvert et la page d'acceuil est affichée
    When l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_accueil_menu_gauche"
    And pause 20 secondes
    Then vérifier que la page affichée est la page d'accueil
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_annuaire_menu_gauche"
    And pause 20 secondes
    Then  vérifier que la page affichée est la page annuaire
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    And pause 20 secondes
    Then vérifier que la page affichée est la page knows store
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_ideation_menu_gauche"
    And pause 20 secondes
    Then vérifier que la page affichée est la page idéation
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 20 secondes
    Then vérifier que la page affichée est la page calendrier et évenement
    And pause 10 secondes
    #When l utilisateur clique sur "Bouton_news_menu_gauche"
    #Then vérifier que la page affichée est la page news