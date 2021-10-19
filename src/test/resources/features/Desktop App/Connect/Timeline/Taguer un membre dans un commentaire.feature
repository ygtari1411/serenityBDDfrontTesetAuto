# Auteur: ygtari
# Feature: Timeline
# Scénario: Taguer un membre dans un commentaire
# Date de création: 14/10/2020



Feature: Timeline: Taguer un membre dans un commentaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0010
  Scenario: Commenter et reagir a une publication

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé taguer un membre dans un commentaire" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

     #Etape 4 : Commenter et liker la publication

    And l utilisateur clique sur "bouton_commenter_statut"
    And l utilisateur saisit "@" dans le champs "champ_commentaire_statut"
    And pause 7 secondes
    And l utilisateur clique sur "premier_membre_afficher"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"


    #Etape 5 : Verifier l'ajout du commentaire et du like

    Then verifier que le tag a ete ajoute

