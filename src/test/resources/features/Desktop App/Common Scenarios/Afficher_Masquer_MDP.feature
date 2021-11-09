# Auteur: wboufade
# Feature: Connexion_Deconnexion
# Scénario:  Afficher / Masquer le mot de passe
# Date de création: 05/01/2021



Feature: Connexion_Deconnexion - Afficher / Masquer le mot de passe

  @WEAVIN
  @WEAVIN-COMMONSCENARIOS
  @WEAVIN-COMMONSCENARIOS-0004
  Scenario: Afficher / Masquer le mot de passe

    Given le navigateur est ouvert et la page d'acceuil est affichée
    When l utilisateur saisit "marc.parenteau@yopmail.com" dans le champs "champ_username"
    And l utilisateur saisit "X3h6oStlry" dans le champs "champ_password"
    Then vérifier que le mot de passe est masqué
    When l utilisateur clique sur "Bouton_afficher_mdp"
    Then vérifier que le mot de passe est affiché