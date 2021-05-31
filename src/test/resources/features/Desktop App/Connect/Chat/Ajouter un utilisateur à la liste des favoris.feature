# Auteur: BenYedder
# Feature: Chat
# Scénario: Ajouter un utilisateur à la liste des favoris
# Date de création: 16/03/2021

Feature: Chat

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0001
  Scenario: Ajouter un utilisateur à la liste des favoris

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout utilisateur à la liste des favoris

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Options_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_utilisateur_Favoris"
    And pause 5 secondes

  #Etape3  vérifier que l utilisateur a été ajouté à la liste des favoris

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 5 secondes
    Then l utilisateur saisit "" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 10 secondes
    Then vérifier que l utilisateur a été ajouté à la liste des favoris


