# Auteur: BenYedder
# Feature: Journalisation
# Scénario: Supprimer une publication de la corbeille
# Date de création: 20/08/2021

Feature: Journalisation - Supprimer une publication de la corbeille

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0007
  Scenario: Supprimer une publication de la corbeille

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

  #Etape 2 : Ajouter une publication

    When l utilisateur saisit "test automatisé Supprimer une publication de la corbeille" dans le champs "Champ_Input_Publication"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_publier_Publication"
    And vérifier que la publication est publié

  #Etape 3 : Supprimer une publication

    When l utilisateur clique sur "Bouton_Options_Publication"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Publication"
    And pause 5 secondes

  #Etape 4 : Verifier la suppression dans la journalisation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 20 secondes
    Then vérifier que la publication supprimé est affiché dans la liste journalisation publications
    And l utilisateur clique sur "Bouton_Corbeille_Supprimer_Puplication"
    And l utilisateur clique sur "Bouton_Corbeille_Supprimer_Confirmation"

