# Auteur: BenYedder
# Feature: Chat
# Scénario: Réagir à un message texte
# Date de création: 04/10/2021

Feature: Chat

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0009
  Scenario: Réagir à un message texte

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape 2 : envoi message texte

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 5 secondes
    And l utilisateur clique sur "Utilisateur_Chercher"
    And pause 5 secondes
    And l utilisateur saisit "Réagir à un message texte " dans le champs "Champ_Input_Message_Chat"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Envoyer_Chat"
    And pause 5 secondes

  #Etape 3 : l'utilisateur 1 se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 4 : l utilisateur 2 verifier la réception de message et réagir

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Notifications_Chat"
    And pause 5 secondes
    And l utilisateur clique sur "Premiere_Notification_chat_Afficher"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Reaction_Message_Chat"
    And pause 5 secondes

  #Etape 5 : l'utilisateur 2 se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 5 : verfication de réaction

    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 5 secondes
    And l utilisateur clique sur "Utilisateur_Chercher"
    And pause 5 secondes
    #Then vérifier que la réaction a été reçu avec succes


