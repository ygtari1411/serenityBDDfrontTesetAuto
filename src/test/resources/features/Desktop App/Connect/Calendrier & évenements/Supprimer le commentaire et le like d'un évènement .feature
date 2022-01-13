# Auteur: ygtari
# Feature: Calendrier & évenements
# Scénario:Supprimer le  Commentaire et le  like d un évènement
# Date de création: 17/02/2021


Feature: Calendrier & évenements - Supprimer le  Commentaire et le  like d un évènement

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0005
  Scenario: Supprimer le  Commentaire et le  like d un évènement

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

    #Etape2  : Ajout évenement

    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page calendrier et évenement
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajout_Evenement"
    And pause 5 secondes
    Then vérifier que le modal de création d'un evenement est affiché
    And pause 5 secondes
    And l utilisateur selectionne "Weavin Admin" dans la liste deroulante "Calendrier"
    #And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique supprimer le commentaire et le  like un evenement" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique supprimer le commentaire et like d un evenement" dans le champs "Champ_Input_Description_Evenement"
    And l utilisateur saisit "Tunis" dans le champs "Champ_Input_Lieu_Evenement"
    And pause 5 secondes
    When l utilisateur clique sur "Date_Debut_Evenement"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And l utilisateur saisit "15:00" dans le champs "Heure_Debut_Evenement"
    And pause 5 secondes
    When l utilisateur clique sur "Date_Fin_Evenement"
    And l utilisateur clique sur "Case_aujoudhui_Calendrier"
    And l utilisateur saisit "16:00" dans le champs "Heure_Fin_Evenement"
    And pause 5 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouveau_evenement"
    And l utilisateur upload "image2" dans le champs "Fichier_attache_nouveau_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Invités_Internes"
    And pause 5 secondes
    And l utilisateur saisit "Ennaceur" dans le champs "Champ_Input_invites_interne_evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Chercher_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Invite_interne_evenement_selectionne"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 10 secondes

    #Etape 3 : Vérification de la création de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    #Then vérifier la création du nouveau evenement

    #Etape 4 :  liker et commenter l'évenement

    When l utilisateur clique sur "Bouton_commentaire_evenement"
    And pause 10 secondes
    And l utilisateur saisit "Commenter et liker un evenement" dans le champs "Champ_Input_Commentaire_Evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_Commentaire_Evenement"
    And pause 10 secondes
    #Then vérifier que le commentaire evenement a été ajouté
    #And pause 10 secondes
    When l utilisateur effectue un hover sur "Bouton_Interaction_Evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Like_Evenement"
    And pause 10 secondes
    #Then vérifier  que le like evenement a été ajouté
   # And pause 10 secondes


    #Etape 5 : Supprimer le commentaire

 #  When l utilisateur clique sur "Icone_Commentaire"
    #And pause 20 secondes
    And l utilisateur effectue un hover sur "Bouton_Option_Commentaire"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Commentaire"
    And pause 15 secondes
    #Then verifier que le commentaire de l evenement est supprimé


    #Etape 6 : Supprimer l'interaction

    When l utilisateur effectue un hover sur "Bouton_Interaction_Evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Like_Evenement"
    And pause 10 secondes
    #Then vérifier  que le like a été supprimé

#Etape 7 : Supprimer l'évenement

    #And pause 5 secondes
    And l utilisateur clique sur "Bouton_options_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_evenement"