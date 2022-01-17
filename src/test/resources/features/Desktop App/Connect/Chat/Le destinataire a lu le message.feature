# Auteur: BenYedder
# Feature: Chat
# Scénario:  Le destinataire a lu le message
# Date de création: 10/06/2021

Feature: Chat - Le destinataire a lu le message

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0008
  Scenario:  Le destinataire a lu le message

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
    And l utilisateur saisit "Vu Message Texte par destinataire" dans le champs "Champ_Input_Message_Chat"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Envoyer_Chat"
    And pause 5 secondes

  #Etape 3 : l'utilisateur 1 se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 4 : l utilisateur 2 verifier la réception de message

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté" est connecté
    And pause 10 secondes
   # When l utilisateur clique sur "Bouton_Notifications_Chat"
    And pause 5 secondes
    And l utilisateur clique sur "Premiere_Notification_chat_Afficher"
    And pause 5 secondes
    Then vérifier que le message a été reçu avec succes

  #Etape 5 : l'utilisateur 2 se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 4 : l utilisateur 1 verifier la vu de message

    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes


