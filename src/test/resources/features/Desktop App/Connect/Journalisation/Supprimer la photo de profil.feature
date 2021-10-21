# Auteur: BenYedder
# Feature: Journalisation
# Scénario: Supprimer la photo de profil
# Date de création: 05/10/2021

Feature: Journalisation - Supprimer la photo de profil

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0008
  Scenario: Supprimer la photo de profil

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Ajout photo de profile

    When l utilisateur clique sur "Username_menu"
    Then vérifier que le profil de l utilisateur est affiché
    And l utilisateur upload photo de profil "image1" dans le champs "H_Upload_photo_de_profil"
    And pause 5 secondes
    Then vérifier que l'image est ajoutée

  #Etape 3 : Suppresion de la photo de profil

    When l utilisateur clique sur "Bouton_supprimer_photo_profil"

  #Etape 4 : Verifier la suppression dans la journalisation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 20 secondes
    Then vérifier que la photo supprimé est affiché dans la liste corbeille publications