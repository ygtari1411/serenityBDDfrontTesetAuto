# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Modifier un évènement avec user externe avec envoi de mail
# Date de création: 22/04/2021

Feature: Calendrier & évenements

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0010
  Scenario: Modifier un évènement avec user externe avec envoi de mail

    #Etape1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "admin" est connecté
    And pause 10 secondes

    #Etape2  : Ajouter un évènement avec user externe avec envoi de mail

    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 10 secondes
    Then vérifier que la page affichée est la page calendrier et évenement
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_Evenement"
    And pause 5 secondes
    Then vérifier que le modal de création d'un evenement est affiché
    And pause 5 secondes
    And l utilisateur selectionne "Weavin Admin" dans la liste deroulante "Calendrier"
    And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique Modification évènement avec user externe avec envoi de mail" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de modifier un évènement avec user externe avec envoi de mail" dans le champs "Champ_Input_Description_Evenement"
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
    And l utilisateur clique sur "Bouton_Invités_Externes"
    And pause 5 secondes
    And l utilisateur saisit "Test User Externe" dans le champs "Champ_Input_Nom_User_Externe"
    And pause 5 secondes
    And l utilisateur saisit "UserExterne@Test.com" dans le champs "Champ_Input_Email_User_Externe"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_User_Externe"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Accepter_envoi_mail_evenement"

    #Etape3 : Vérification de la création de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement de modifcation avec user externe avec envoi mail

    #Etape4 : la modification de l'évenement

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
    And pause 10 secondes
    And l utilisateur saisit "User Externe Test" dans le champs "Champ_Input_Nom_User_Externe"
    And pause 5 secondes
    And l utilisateur saisit "UserExterneTest@Test.com" dans le champs "Champ_Input_Email_User_Externe"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_User_Externe"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_modifier_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Accepter_envoi_mail_evenement"


    #Etape 5 : Vérification de la modification de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la modification de l evenement ajoute
