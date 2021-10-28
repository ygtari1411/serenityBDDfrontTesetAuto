# Auteur: ygtari
# Feature: Timeline
# Scénario: Modifier le commentaire et la reaction d une publication
# Date de création: 14/10/2020



Feature: Timeline - Modifier le commentaire et la reaction d une publication

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0009
  Scenario: Modifier le commentaire et la reaction d une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé publication statut" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

     #Etape 4 : Commenter et liker la publication

    And l utilisateur clique sur "bouton_commenter_statut"
    And l utilisateur saisit "Test automatisé commenter une publication" dans le champs "champ_commentaire_statut"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"
    And l utilisateur clique sur "bouton_Liker_statut"
    And pause 10 secondes

    #Etape 5 : Verifier l'ajout du commentaire et du like

    Then verifier que le commentaire et le like du statut on ete ajoute

   #Etape 5 : Modifier le commentaire et la reaction

    And l utilisateur clique sur "bouton_commentaire_timeline"
    And l utilisateur clique sur "bouton_option_commentaire"
    And l utilisateur clique sur "bouton_option_editer_commentaire_timeline"
    And pause 5 secondes
    And l utilisateur modifie "Modification d'un commentaire" dans le champs "champ_cemmentaire_modification_timeline"
    And l utilisateur clique sur "bouton_envoyer_commentaire_timeline_modifier"
    Then verifier que le commentaire a ete modifier avec success
