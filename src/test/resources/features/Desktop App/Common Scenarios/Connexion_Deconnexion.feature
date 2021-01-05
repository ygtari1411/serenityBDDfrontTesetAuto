# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Connexion avec identifiants corrects / Connexion avec identifiants incorrects
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
