# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Ajouter un évènement avec user externe
# Date de création: 22/04/2021

Feature: Calendrier & évenements

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0008
  Scenario: Ajouter un évènement avec user externe

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "admin" est connecté
    And pause 10 secondes

    #Etape2  : Ajouter un évènement avec user externe

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
    And l utilisateur saisit "Test automatique création évènement avec user externe" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un évènement avec user externe" dans le champs "Champ_Input_Description_Evenement"
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
    And l utilisateur clique sur "Non_envoi_mail_evenement"

    #Etape 3 : Vérification de la création de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement avec user externe
