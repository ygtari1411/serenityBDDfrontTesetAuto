# Auteur: BenYedder
# Feature: Chat
# Scénario: Envoyer une vidéo
# Date de création: 24/05/2021

Feature: Chat - Envoyer une vidéo

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0007
  Scenario: Envoyer une vidéo

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape 2 : envoi image

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 5 secondes
    And l utilisateur clique sur "Utilisateur_Chercher"
    And pause 10 secondes
    And l utilisateur saisit "Message Vidéo de Test" dans le champs "Champ_Input_Message_Chat"
    And pause 10 secondes
    And l utilisateur upload video "Video2" dans le chat "Champ_Input_Image_Chat"
    And pause 30 secondes
    And l utilisateur clique sur "Bouton_Envoyer_Chat"
    And pause 15 secondes

  #Etape 3 : l'utilisateur 1 se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 4 : l utilisateur 2 verifier la réception de l'image

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Notifications_Chat"
    And pause 10 secondes
    And l utilisateur clique sur "Premiere_Notification_chat_Afficher"
    And pause 10 secondes
    Then vérifier que le message video a été reçu avec succes

