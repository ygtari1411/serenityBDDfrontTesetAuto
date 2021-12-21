# Auteur: ygtari
# Feature: Timeline
# Scénario: Repondre et reagir a un sous commentaire d une publication
# Date de création: 14/10/2020



Feature: Timeline - Repondre et reagir a un sous commentaire d une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0017
  Scenario: Repondre et reagir a un sous commentaire d une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Repondre et reagir a un sous commentaire d une publication" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

      #Etape 4 : Commenter la publication

    And l utilisateur clique sur "bouton_commenter_statut"
    And l utilisateur saisit "Test automatisé ajouter un sous commentaire" dans le champs "champ_commentaire_statut"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"
    And pause 20 secondes

     #Etape 5 : Reagir au commentaire

    And l utilisateur clique sur "Logo_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "bouton_interagir_commentaire"
    And pause 10 secondes
    And l utilisateur saisit "Test auto reagir a un sous commentaire" dans le champs "champ_input_sous_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_sous_commentaire"
    And pause 10 secondes

    #Etape 6 : Vérifier que le sous commentaire a été comptabilise

    Then verifier que le sous commentaire a ete comptabilise

