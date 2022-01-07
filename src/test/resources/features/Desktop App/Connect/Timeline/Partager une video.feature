# Auteur: ygtari
# Feature: TimeLine
# Scénario: Partager une video
# Date de création: 23/08/2021

Feature: Timeline - Partager une video

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0012
  Scenario: Partager une video

   #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

   #Etape 2 : Creation statut

    And l utilisateur ajoute une video a la time line
    And pause 10 secondes
    And l utilisateur clique sur "bouton_publier_statut"

