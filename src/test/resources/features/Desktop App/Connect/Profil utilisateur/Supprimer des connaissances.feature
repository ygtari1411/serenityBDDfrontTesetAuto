# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Supprimer des connaissances
# Date de création: 05/04/2021

Feature: Profil utilisateur - Supprimer des connaissances

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0014
  Scenario: Supprimer des connaissances

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout d'une citation

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur saisit "Test Connaissance à Supprimer" dans le champs "Champ_Input_Connaissances"
    And pause 5 secondes
    And l utilisateur clique sur Entree pour l ajout de Connaissance
    And pause 10 secondes

  #Etape3  vérifier que  connaissance a été ajouté

    Then vérifier que connaissance a été ajouté

  #Etape4  Supprimer la connaissance ajouté

    When l utilisateur clique sur "Bouton_Supprimer_Connaissance"
    Then vérifier que connaissance a été supprimé


