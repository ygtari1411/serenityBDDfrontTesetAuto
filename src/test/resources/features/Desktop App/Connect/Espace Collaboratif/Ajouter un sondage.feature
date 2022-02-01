# Auteur: BenYedder
# Feature: TeamLab
# Scénario: Ajouter un sondage
# Date de création: 28/09/2021


Feature: TeamLab - Ajouter un sondage

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TEAMLAB
  @WEAVIN-TEAMLAB-0011
  Scenario: Ajouter un sondage


  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Accéder au rubrique team lab et création de Bulle

    When l utilisateur clique sur "Bouton_Teamlab_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
    #And pause 5 secondes
    #And l utilisateur clique sur "Boutton_Ajouter_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur le bouton ajouter bulle
    And l utilisateur saisit "Sondage Bulle Test" dans le champs "Champ_Input_Name_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Sujet de Sondage Bulle Test" dans le champs "Champ_Input_Sujet_Bulle"
    And pause 5 secondes
    And l utilisateur selectionne "Publique" dans la liste deroulante "Liste_Type_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Inviter_Membres_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Ennaceur" dans le champs "Champ_Input_invites_interne_evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Chercher_Invite_interne_evenement"
    And pause 5 secondes
  #  And l utilisateur clique sur "Invite_interne_evenement_selectionne"
  #  And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Créer_Bulle"
    And pause 5 secondes

   #Etape 3 : Verifier la création de bulle

    And l utilisateur saisit "Sondage Bulle Test" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 20 secondes
    #Then verifier que la bulle a ete ajoutee

  #Etape 4 : Envoyer une image
    And pause 5 secondes
    And l utilisateur clique sur "Titre_Bulle_Rechercher"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Create_Sondage_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Question de sondage ?" dans le champs "Champ_Input_Question_Sondage"
    And pause 5 secondes
    And l utilisateur saisit "option 1" dans le champs "Champ_Input_Option1_Sondage"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Option_Sondage"
    And pause 5 secondes
    And l utilisateur saisit "option 2" dans le champs "Champ_Input_Option2_Sondage"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Lancer_Sondage"
    And pause 10 secondes
    Then verifier que le sondage a ete creé





