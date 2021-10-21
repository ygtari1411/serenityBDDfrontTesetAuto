# Auteur: ygtari
# Feature: TimeLine
# Scénario: Partager un album
# Date de création: 07/09/2021

Feature: Timeline - Partager un album

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0004
  Scenario: Partager un album

   #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

   #Etape 2 : Creation statut

    And l utilisateur ajoute une photo a la time line
    And pause 10 secondes
    And l utilisateur ajoute une photo a la time line
    And pause 10 secondes
    And l utilisateur clique sur "bouton_publier_statut"