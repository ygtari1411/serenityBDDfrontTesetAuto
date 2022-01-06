# Auteur: ygtari
# Feature: Timeline
# Scénario: Suppression d une publication par un administrateur
# Date de création: 11/10/2021



Feature: Timeline - Suppression d une publication par un administrateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0021
  Scenario: Supprimer un commentaire par un administrateur

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé publication statut" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

    #Etape 3 : verification de la création d'un statut

    Then Vérifier que le statut est publié

    #Etape 4 : commenter le statut

    And l utilisateur clique sur "bouton_commenter_statut"
    And l utilisateur saisit "Test automatisé commenter une publication" dans le champs "champ_commentaire_statut"
    And l utilisateur clique sur "bouton_envoyer_commentaire_statut"
    And pause 10 secondes

    #Etape 5 : l'utilisateur Marc se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

    #Etape 6 : Le deuxieme utilisateur se connecte  pour refuser l'evenement

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes

    #Etape 7 : Supprimer le commentaire

    And l utilisateur clique sur "bouton_commentaire_timeline_administrateur"
    And l utilisateur clique sur "bouton_option_commentaire"
    And l utilisateur clique sur "bouton_option_supprimer_commentaire_administrateur"
    And pause 5 secondes
    Then verifier que le commentaire a ete supprime avec success
