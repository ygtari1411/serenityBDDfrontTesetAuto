# Auteur: ygtari
# Feature: Annuaire
# Scénario: Un utilisateur supprimer n'apparait pas dans la rubrique annuaire
# Date de création: 15/06/2021



Feature: Annuaire - Un utilisateur supprimer n'apparait pas dans la rubrique annuaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0005
  Scenario: Un utilisateur supprimer n'apparait pas dans la rubrique annuaire

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 5 secondes

    #Etape 2 : Accéder au rubrique Gestion utilisateurs

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_utilisateurs"
    And pause 15 secondes

    Then vérifier que le modal de Gestion des comptes est affiché
    And pause 5 secondes


    #Etape 3 : Rechercher L'utilisateur a  supprimer
    And l utilisateur clique sur "invites_utilisateurs"
    And pause 5 secondes
    And l utilisateur saisit "suzanne" dans le champs "Champ_Input_Chercher_des_membres"
    And pause 15 secondes

    #Etape 4 :Supprimer l'utilisateur

    And l utilisateur clique sur "Bouton_Supprimer_Utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_annuaire_menu_gauche"
    And pause 10 secondes

   #Etape 5 :Rechercher par nom et vérifier que la carte de visite  de l'utilsateur  n'apparait pas

    And l utilisateur saisit "suzanne" dans le champs "Champ_Input_Chercher_des_membres_Rubrique_Annuaire"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Chercher_des_membres_Annuaire"
    And pause 5 secondes
    Then verifier que la carte visite de l'utilisateur"suzanne" n apparait pas dans l annuaire


