# Auteur: ygtari
# Feature: Timeline
# Scénario: Taguer une personne dans une publication
# Date de création: 26/10/2021



Feature: Timeline - Taguer une personne dans une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0014
  Scenario: Taguer une personne dans une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "@" dans le champs "champ_statut"
    And pause 7 secondes
    And l utilisateur clique sur "premier_membre_afficher_TimeLine"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le tag apparait dans le  statut  publié