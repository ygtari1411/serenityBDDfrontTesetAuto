# Auteur: ygtari
# Feature: TimeLine
# Scénario: Partager une piece jointe
# Date de création: 23/08/2021

Feature: Timeline - Partager une piece jointe

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0010
  Scenario: Partager une piece jointe

   #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

   #Etape 2 : Creation statut

    And l utilisateur ajoute une piece jointe a la time line
    And pause 10 secondes
    And l utilisateur clique sur "bouton_publier_statut"

