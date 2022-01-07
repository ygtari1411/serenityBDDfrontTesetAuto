# Auteur: ygtari
# Feature: Timeline
# Scénario: Suppression d une publication par un administrateur
# Date de création: 11/10/2021



Feature: Timeline - Suppression d une publication par un administrateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0015
  Scenario: Suppression d une publication par un administrateur

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé publication statut" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"

      #Etape 3 : verification de la création d'un statut

     Then Vérifier que le statut est publié

      #Etape 4 : l'utilisateur Marc se deconnecte

      And  l utilisateur se deconnecte
      And pause 10 secondes

    #Etape 5 : Le deuxieme utilisateur se connecte  pour refuser l'evenement

      And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
      And pause 10 secondes

     #Etape 6 : Supprimer la publication

      And l utilisateur clique sur "bouton_option_premiere_publication_afficher"
      And l utilisateur clique sur "bouton_option_Supprimer_premiere_publication_afficher_admin"

    #Etape 7 : Vérifier  la suppression de la publication

     Then Vérifier que le statut est supprime