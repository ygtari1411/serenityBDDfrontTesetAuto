# Auteur: BenYedder
# Feature: TeamLab
# Scénario: Réagir à un message dans un groupe de discussion
# Date de création: 28/09/2021


Feature: TeamLab - Réagir à un message dans un groupe de discussion

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TEAMLAB
  @WEAVIN-TEAMLAB-0005
  Scenario: Réagir à un message dans un groupe de discussion

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Accéder au rubrique team lab et création de Bulle

    When l utilisateur clique sur "Bouton_Teamlab_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Ajouter_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Réagir A Un Message Dans Un Groupe De Discussion" dans le champs "Champ_Input_Name_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Sujet de Réagir à un message Bulle de test" dans le champs "Champ_Input_Sujet_Bulle"
    And pause 5 secondes
    And l utilisateur selectionne "Publique" dans la liste deroulante "Liste_Type_Bulle"
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
    And pause 10 secondes

   #Etape 3 : Verifier la création de bulle

    And l utilisateur saisit "Réagir A Un Message Dans Un Groupe De Discussion" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 5 secondes
    Then verifier que la bulle a ete ajoutee
    And pause 5 secondes

  #Etape 4 : Ecrire un message et faire une réaction

    And l utilisateur clique sur "Titre_Bulle_Rechercher"
    And pause 5 secondes
    And l utilisateur saisit "Réagir à un message de Bulle de test" dans le champs "Champ_Input_Message_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur Entree pour l envoi de message
    And pause 5 secondes
    #Then verifier que la message a ete envoye
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Reaction_Message_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_aime_Message_Bulle"
    And pause 5 secondes
    #Then vérifier l ajout correct du Like Bulle








