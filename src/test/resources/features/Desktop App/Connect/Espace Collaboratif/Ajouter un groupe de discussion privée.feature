# Auteur: BenYedder
# Feature: TeamLab
# Scénario: Ajouter un groupe de discussion privée
# Date de création: 28/09/2021


Feature: TeamLab - Ajouter un groupe de discussion privée

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TEAMLAB
  @WEAVIN-TEAMLAB-0010
  Scenario: Ajouter un groupe de discussion privée

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Accéder au rubrique team lab

    When l utilisateur clique sur "Bouton_Teamlab_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
    And pause 5 secondes
    #And l utilisateur clique sur "Boutton_Ajouter_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur le bouton ajouter bulle
    And l utilisateur saisit "Bulle Test Privée" dans le champs "Champ_Input_Name_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Sujet de Bulle de test" dans le champs "Champ_Input_Sujet_Bulle"
    And pause 5 secondes
    And l utilisateur selectionne "Privée" dans la liste deroulante "Liste_Type_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Inviter_Membres_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Ennaceur" dans le champs "Champ_Input_invites_interne_evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Chercher_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Invite_interne_evenement_selectionne"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Créer_Bulle"
    And pause 5 secondes

   #Etape 3 : Verifier la création de bulle

    And l utilisateur saisit "Bulle Test Privée" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 5 secondes
    Then verifier que la bulle a ete ajoutee

  #Etape 4 : l'utilisateur Marc se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 5 : Le deuxieme utilisateur se connecte  pour accepter l'evenement

    And l'utilisateur "yassine.gtari@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Teamlab_menu_gauche"
    And pause 5 secondes
    And l utilisateur saisit "Bulle Test Privée" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 5 secondes
    Then verifier que la bulle ne s affiche pas
