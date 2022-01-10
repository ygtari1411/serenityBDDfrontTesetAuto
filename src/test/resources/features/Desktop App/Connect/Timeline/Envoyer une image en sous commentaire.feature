# Auteur: gayadi
# Feature: Timeline
# Scénario:Envoyer une image en sous commentaire
# Date de création: 18/11/2021

Feature: Timeline - Envoyer une image en sous commentaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0003

  Scenario: Envoyer une image en sous commentaire



  #Etape1 : Connexion utilisateur 1
    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Ajout statut
    When l utilisateur saisit "Test automatique d'envoi une image en sous commentaire" dans le champs "champ_statut"
    And l utilisateur clique sur "bouton_publier_statut"
    And pause 5 secondes
    Then Vérifier que le statut est publié

  #Etape3 : déconnection utilisateur 1/connection utilisateur 2
    When l utilisateur se deconnecte
    And pause 10 secondes
    And  l'utilisateur "yassine.gtari@advyteam.com" est connecté
    And pause 5 secondes


  #Etape4 :  Ajout commentaire
    When l utilisateur clique sur "Bouton_Notifications"
    And pause 5 secondes
    And l utilisateur clique sur "Premiere_Notification_Afficher"
    And pause 5 secondes
    Then Vérifier que le statut affiché est le statut publié
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Repondre_Statut_Popup"
    And pause 5 secondes
    And l utilisateur saisit "envoyez une image en sous commentaire " dans le champs "Champ_Input_Commentaire_Publication"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Envoyer_Commentaire_Publication"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Like_Statut_Popup"
    And pause 5 secondes
    Then verifier que le commentaire et le like du statut popup on ete ajoute

  #Etape5 : déconnection utilisateur 2 / connection utilisateur 1

  #Etape 6: Ajout sous commentaire (image)
