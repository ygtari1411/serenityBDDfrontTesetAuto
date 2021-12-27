# Auteur: ygtari
# Feature: Timeline
# Scénario: Supprimer le sous commentaire d une publication
# Date de création: 27/12/2021



Feature: Timeline - Supprimer le sous commentaire d une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0019
  Scenario: Supprimer le sous commentaire d une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Supprimer le sous commentaire d une publication" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

      #Etape 4 : Commenter la publication

    And l utilisateur clique sur "bouton_commenter_statut"
    And l utilisateur saisit "Test automatisé Supprimer le sous commentaire d une publication" dans le champs "champ_commentaire_statut"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"
    And pause 20 secondes

     #Etape 5 : Reagir au commentaire

    And l utilisateur clique sur "Logo_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "bouton_interagir_commentaire"
    And pause 10 secondes
    And l utilisateur saisit "Test auto Supprimer le sous commentaire d une publication" dans le champs "champ_input_sous_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_sous_commentaire"
    And pause 10 secondes

     #Etape 6 : Supprimer le sous commentaire

    And l utilisateur clique sur "Logo_sous_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Option_Sous_Commentaire"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Sous_Commentaire"
    And pause 30 secondes

    #Etape  : Vérifier que le sous commentaire a été supprimé

     Then vérifier que le sous commentaire a ete supprime
