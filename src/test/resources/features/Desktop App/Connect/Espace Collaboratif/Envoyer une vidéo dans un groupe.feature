# Auteur: BenYedder
# Feature: TeamLab
# Scénario: Envoyer une vidéo dans un groupe
# Date de création: 28/09/2021


Feature: TeamLab - Envoyer une vidéo dans un groupe

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TEAMLAB
  @WEAVIN-TEAMLAB-0009
  Scenario: Envoyer une vidéo dans un groupe

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Accéder au rubrique team lab et création de Bulle

    When l utilisateur clique sur "Bouton_Teamlab_menu_gauche"
    And pause 5 secondes
   And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
   # And pause 5 secondes
    #And l utilisateur clique sur "Boutton_Ajouter_Bulle"
    And pause 5 secondes
    And l utilisateur clique sur le bouton ajouter bulle
    And l utilisateur saisit "Envoi vidéo Bulle Test" dans le champs "Champ_Input_Name_Bulle"
    And pause 5 secondes
    And l utilisateur saisit "Sujet de Envoi vidéo Bulle Test" dans le champs "Champ_Input_Sujet_Bulle"
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

    And l utilisateur saisit "Envoi vidéo Bulle Test" dans le champs "Champ_input_Filtre_Nom_Bulle"
    And pause 5 secondes
    #Then verifier que la bulle a ete ajoutee

  #Etape 4 : Envoyer une vidéo

    And l utilisateur clique sur "Titre_Bulle_Rechercher"
    And pause 5 secondes
   And l utilisateur clique sur "Bouton_upload_photo_Bulle"
    And pause 5 secondes
    And pause 5 secondes
    And l utilisateur saisit une video dans la bulle
    And pause 5 secondes
    #And l utilisateur upload video "Video2" dans le message Bulle "H_Upload_photo_Mesage_Bulle"
   # And pause 5 secondes
    And l utilisateur clique sur "Bouton_Publier_Album_Bulle"
    #Then verifier que l image a ete envoye










