# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Connexion à l'espace Weavin
# Scénario:  Accéder au menu Weavin
# Scénario:  Déconnexion de l'espace Weavin
# Scénario:  Afficher / Masquer le mot de passe
# Scénario:  Accéder aux différents sous menu
# Date de création: 27/10/2020


Feature: Connexion-Deconnexion


  @WEAVIN
    @WEAVIN-COMMONSCENARIOS
    @WEAVIN-COMMONSCENARIOS-0001
  Scenario Outline: Connexion avec identifiants corrects / Connexion avec identifiants incorrects

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l utilisateur saisit "<User>" dans le champs "champ_username"
    And l utilisateur saisit "<Password>" dans le champs "champ_password"
    And l utilisateur clique sur "login_button"
    Then vérifier le résultat de la connexion



    Examples:
      | User  | Password |
      | admin | admin    |
      | ssss  | pppp     |
      | admin | pppp     |
      | ssss  | admin    |


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


  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0003
  Scenario: Déconnexion de l'espace weavin

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté
    And pause 3 secondes
    When l utilisateur effectue un hover sur "Username_menu"
    And pause 1 secondes
    Then Vérifier que le menu s'affiche
    When l utilisateur clique sur "logout_button"
    And pause 3 secondes
    Then vérifier que l'utilisateur est deconnecté


  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0004
  Scenario: Afficher / Masquer le mot de passe

    Given le navigateur est ouvert et la page d'acceuil est affichée
    When l utilisateur saisit "admin" dans le champs "champ_username"
    And l utilisateur saisit "admin" dans le champs "champ_password"
    Then vérifier que le mot de passe est masqué
    When l utilisateur clique sur "Bouton_afficher_mdp"
    Then vérifier que le mot de passe est affiché


  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0005
  Scenario: Accéder aux différents sous menu

    Given le navigateur est ouvert et la page d'acceuil est affichée
    When l'utilisateur "admin" est connecté
    And l utilisateur clique sur "Bouton_accueil_menu_gauche"
    Then vérifier que la page affichée est la page d'accueil
    When l utilisateur clique sur "Bouton_annuaire_menu_gauche"
    Then  vérifier que la page affichée est la page annuaire
    When l utilisateur clique sur "Bouton_knowstore_menu_gauche"
    Then vérifier que la page affichée est la page knows store
    When l utilisateur clique sur "Bouton_ideation_menu_gauche"
    Then vérifier que la page affichée est la page idéation
    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    Then vérifier que la page affichée est la page calendrier et évenement
    When l utilisateur clique sur "Bouton_news_menu_gauche"
    Then vérifier que la page affichée est la page news

