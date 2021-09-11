# Auteur: BenYedder
# Feature: Chat
# Scénario: Ajouter et supprimer un utilisateur à la liste des favoris
# Date de création: 16/03/2021

Feature: Chat

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CHAT
  @WEAVIN-CHAT-0001
  Scenario: Ajouter et supprimer un utilisateur à la liste des favoris

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 20 secondes

  #Etape2  : Ajout utilisateur à la liste des favoris

    When l utilisateur clique sur "Bouton_Ouvrir_List_Chat"
    And pause 10 secondes
    And l utilisateur saisit "Mohamed Ennaceur Ben Yedder" dans le champs "Champ_Input_Chercher_vos_amis"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajouter_utilisateur_Favoris"
    And pause 10 secondes

  #Etape3  vérifier que l utilisateur a été ajouté à la liste des favoris

    Then vérifier que l utilisateur a été ajouté à la liste des favoris
    And pause 10 secondes

  #Etape4  supprimer l utilisateur ajouté de la liste des favoris

    And l utilisateur clique sur "Bouton_Supprimer_utilisateur_Favoris"
    And pause 10 secondes
    Then vérifier que la liste des favoris est vide

