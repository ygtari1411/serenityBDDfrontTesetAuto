# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Connexion à l'espace Weavin
# Scénario:  Accéder au menu Weavin
# Scénario:  Déconnexion de l'espace Weavin
# Scénario:  Afficher / Masquer le mot de passe
# Date de création: 27/10/2020


@WEAVIN
@WEAVIN-COMMONSCENARIOS
@WEAVIN-COMMONSCENARIOS-0002

Feature: Connexion-Deconnexion

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