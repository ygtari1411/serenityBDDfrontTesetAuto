# Auteur: BenYedder
# Feature: TeamLab
# Scénario: Supprimer un groupe de discussion
# Date de création: 27/09/2021


Feature: TeamLab - Supprimer un groupe de discussion

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TEAMLAB
  @WEAVIN-TEAMLAB-0004
  Scenario: Supprimer un groupe de discussion

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
    And l utilisateur saisit "Supprimer Un Groupe De Discussion" dans le champs "Champ_Input_Name_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Sujet de Supprimer Bulle test" dans le champs "Champ_Input_Sujet_Bulle"
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
    And pause 5 secondes

   #Etape 3 : Verifier la création de bulle

    And l utilisateur saisit "Supprimer Un Groupe De Discussion" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 5 secondes
    #Then verifier que la bulle a ete ajoutee

  #Etape 4 : Supprimer la bulle

    And l utilisateur clique sur "Titre_Bulle_Rechercher"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Modifier_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Supprimer_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur "Boutton_Confirmation_Supprimer_Bulle"
    And pause 5 secondes
    #Then verifier que la bulle a ete supprime







