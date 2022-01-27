# Auteur: ygtari
# Feature: Timeline
# Scénario: Modifier le  sous commentaire et la reaction d une publication
# Date de création: 14/10/2020



Feature: Timeline - Modifier le  sous commentaire et la reaction d une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0005
  Scenario: Modifier le  sous commentaire et la reaction d une publication


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
    And l utilisateur saisit "Test automatisé modifier un sous commentaire" dans le champs "champ_commentaire_statut"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"
    And pause 20 secondes


     #Etape 5 : Reagir au commentaire

    And l utilisateur clique sur "Logo_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "bouton_interagir_commentaire"
    And pause 10 secondes
    And l utilisateur effectue un hover sur "champ_input_sous_commentaire_statut"
    And l utilisateur saisit "Test auto modifier un sous commentaire" dans le champs "champ_input_sous_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_sous_commentaire"
    And pause 10 secondes

    #Etape 6 : Modifier le sous commentaire

    And l utilisateur clique sur "Logo_sous_commentaire_statut"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Option_Sous_Commentaire"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Editer_Sous_Commentaire"
    And pause 10 secondes
    And l utilisateur effectue un hover sur "Nom_membres_sous_commentaire"
    #And l utilisateur saisit "Test 1 auto modifier un sous commentaire" dans le champs "champ_input_sous_commentaire_statut"
    And l utilisateur modifie "Modification sous commentaire" dans le champs "Input_Champs_Sous_commentaire_Modifie"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_sous_commentaire"
