# Auteur: ygtari
# Feature: TimeLine
# Scénario: Partager une image
# Date de création: 23/08/2021

Feature: TImeline - Partager une image

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0009
  Scenario: Partager une image

   #Etape 1 : Connexion

     Given le navigateur est ouvert et la page d'acceuil est affichée
     And l'utilisateur "marc.parenteau@yopmail.com" est connecté

   #Etape 2 : Creation statut

     And l utilisateur ajoute une photo a la time line
     And pause 10 secondes
     And l utilisateur clique sur "bouton_publier_statut"

