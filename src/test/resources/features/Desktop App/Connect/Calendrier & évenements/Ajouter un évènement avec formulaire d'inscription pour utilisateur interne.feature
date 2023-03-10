# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Ajouter un évènement avec formulaire d'inscription pour utilisateur interne
# Date de création: 25/05/2021


Feature: Calendrier & évenements - Ajouter un évènement avec formulaire d'inscription pour utilisateur interne

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0017
  Scenario: Ajouter un évènement avec formulaire d'inscription pour utilisateur interne

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape2  : Ajout évenement

    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page calendrier et évenement
    And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Fermer_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajout_Evenement"
    And pause 5 secondes
    Then vérifier que le modal de création d'un evenement est affiché
    And pause 5 secondes
    And l utilisateur selectionne "Marc Parenteau" dans la liste deroulante "Calendrier"
    #And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique création evenement avec formulaire d'inscription pour utilisateur interne" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un evenement avec formulaire d'inscription pour utilisateur interne" dans le champs "Champ_Input_Description_Evenement"
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
    And pause 10 secondes
# Creation du formulaire
    #And l utilisateur clique sur "Bouton_Ajouter_Formulaire"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_titre"
    #And l utilisateur saisit "Champ titre de formulaire" dans le champs "Champ_Input_champ_titre"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_zone_text"
    #And l utilisateur saisit "Champ Zone de text de formulaire" dans le champs "Champ_Input_champ_zone_text"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_nombre"
    #And l utilisateur saisit "Champ nombre de formulaire" dans le champs "Champ_Input_champ_nombre"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_Date"
    #And l utilisateur saisit "Champ date de formulaire" dans le champs "Champ_Input_champ_date"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_Liste_choix"
    #And l utilisateur saisit "Champ liste des choix de formulaire" dans le champs "Champ_Input_champ_Liste_choix"
    #And l utilisateur saisit "Choix 1" dans le champs "Champ_Input_choix_Liste_choix"
    #And l utilisateur clique sur Entree pour l ajout de choix
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_cases_coucher"
    #And l utilisateur saisit "Champ cases à coucher de formulaire" dans le champs "Champ_Input_champ_cases_coucher"
    #And l utilisateur saisit "Case 1" dans le champs "Champ_Input_case_cases_coucher"
    #And l utilisateur clique sur Entree pour l ajout de case
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_radio"
    #And l utilisateur clique sur "Bouton_Ajouter_champ_Document"
    #And l utilisateur saisit "Champ document de formulaire" dans le champs "Champ_Input_champ_Document"
    #And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Valider_formulaire"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 10 secondes

    #Etape 3 : Vérification de la création de l'évenement avec formulaire

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement avec formulaire
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Fermer_Evenement"
    And pause 5 secondes

    #Etape 4 : l'utilisateur Marc se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

    #Etape 5 : Le deuxieme utilisateur se connecte pour verifier qu'il recoit une invitation

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Notifications"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Notifications_Evenement"
    And pause 5 secondes
    Then vérifier la réception de l'invitation

     #Etape 6 : Switch compte

    And  l utilisateur se deconnecte
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

    #Etape 7 : Supprimer l'évenement

    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 5 secondes
    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_options_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_evenement"

