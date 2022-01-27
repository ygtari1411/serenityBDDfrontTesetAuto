# Auteur: BenYedder
# Feature: Journalisation
# Scénario: Restaurer la photo de profil
# Date de création: 28/10/2021

Feature: Journalisation - Restaurer  la photo de profil

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATIOnN
  @WEAVIN-JOURNALISATION-0010
  Scenario: Restaurer  la photo de profil

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Ajout photo de profile

    When l utilisateur clique sur "Username_menu"
    Then vérifier que le profil de l utilisateur est affiché
    And l utilisateur upload photo de profil "image1" dans le champs "H_Upload_photo_de_profil"
    And pause 5 secondes
    Then vérifier que l'image est ajoutée
    And pause 5 secondes

  #Etape 3 : Suppresion de la photo de profil

    When l utilisateur clique sur "Username_menu"
    And pause 5 secondes
    When l utilisateur effectue un hover sur "Photo_profil_user"
    And l utilisateur clique sur "Bouton_supprimer_photo_profil"
    And pause 5 secondes

  #Etape 4 : Verifier la suppression dans la journalisation

    #When l utilisateur effectue un hover sur "Username_menu"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    #And pause 5 secondes
    #And l utilisateur clique sur "Rubrique_Corbeille"
    #And pause 10 secondes
    #Then vérifier que le modal de Gestion des publications est affiché
    #And pause 20 secondes
    #Then vérifier que la photo supprimé est affiché dans la liste corbeille publications

  #Etape 5 : Restaurer la photo
    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And l utilisateur clique sur "Bouton_Restaurer_Element"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    And l utilisateur clique sur "Username_menu"
    And pause 5 secondes
    Then vérifier que l'image est ajoutée