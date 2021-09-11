# Auteur: BenYedder
# Feature: Chat
# Scénario: Chercher un utilisateur
# Date de création: 04/05/2021

Feature: Chat

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0003
  Scenario: Chercher un utilisateur

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Chercher utilisateur

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 5 secondes
    Then vérifier que l utilisateur chercher affiche