# Auteur: BenYedder
# Feature: Journalisation
# Scénario: Restaurer une publication
# Date de création: 01/11/2021

Feature: Journalisation - Restaurer une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0012

  Scenario: Restaurer une publication

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

  #Etape 2 : Ajouter une publication

    When l utilisateur saisit "test automatisé Restaurer une publication" dans le champs "Champ_Input_Publication"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_publier_Publication"
    And pause 5 secondes
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
    Then vérifier que la publication à restaurer est supprimée et affichée dans le journal des publications

  #Etape 5 : restaurer la publication
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Restaurer_Element"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_accueil_menu_gauche"
    And pause 5 secondes
   # And vérifier que la publication est restauré


