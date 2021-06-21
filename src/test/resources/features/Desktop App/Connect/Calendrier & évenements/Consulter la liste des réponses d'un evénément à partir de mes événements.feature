# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Consulter la liste des réponses d'un événement à partir de mes événements
# Date de création: 27/04/2021


Feature: Calendrier & évenements

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0021
  Scenario: Consulter la liste des réponses d'un événement à partir de mes événements

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

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
    And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique création evenement" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un evenement" dans le champs "Champ_Input_Description_Evenement"
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
    And l utilisateur selectionne "adriel jacobson" dans la liste deroulante des invites interne "invites_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 5 secondes

    #Etape 3 : Vérification de la création de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement
    And pause 5 secondes

    #Etape 4 : la modification de l'évenement

    When l utilisateur clique sur "Bouton_options_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Option_modifier_evenement"
    And pause 5 secondes
    And l utilisateur selectionne "Privé" dans la liste deroulante "Type_Evenement"
    And pause 5 secondes
    And l utilisateur saisit "Test automatique modification evenement" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de la modification d'un evenement" dans le champs "Champ_Input_Description_Evenement"
    And l utilisateur saisit "Sousse" dans le champs "Champ_Input_Lieu_Evenement"
    And pause 5 secondes
    And l utilisateur saisit "17:00" dans le champs "Heure_Debut_Evenement"
    And pause 5 secondes
    And l utilisateur saisit "18:00" dans le champs "Heure_Fin_Evenement"
    And pause 5 secondes
    And l utilisateur selectionne "aedan bradley" dans la liste deroulante des invites interne "invites_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_modifier_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 10 secondes

    #Etape 5 : Vérification de la modification de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la modification de l evenement ajoute
