# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Ajouter un évènement avec formulaire d'inscription pour utilisateur externe
# Date de création: 28/05/2021


Feature: Calendrier & évenements - Ajouter un évènement avec formulaire d'inscription pour utilisateur externe

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0020
  Scenario: Ajouter un évènement avec formulaire d'inscription pour utilisateur externe

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
    And l utilisateur selectionne "Marc Parenteau" dans la liste deroulante "Calendrier"
    #And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique création evenement avec formulaire d'inscription pour utilisateur externe" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de l'ajout d'un evenement avec formulaire d'inscription pour utilisateur externe" dans le champs "Champ_Input_Description_Evenement"
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

    # Creation du formulaire
    And l utilisateur clique sur "Bouton_Ajouter_Formulaire"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_titre"
    And l utilisateur saisit "Champ titre de formulaire" dans le champs "Champ_Input_champ_titre"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_zone_text"
    And l utilisateur saisit "Champ Zone de text de formulaire" dans le champs "Champ_Input_champ_zone_text"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_nombre"
    And l utilisateur saisit "Champ nombre de formulaire" dans le champs "Champ_Input_champ_nombre"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_Date"
    And l utilisateur saisit "Champ date de formulaire" dans le champs "Champ_Input_champ_date"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_Liste_choix"
    And l utilisateur saisit "Champ liste des choix de formulaire" dans le champs "Champ_Input_champ_Liste_choix"
    And l utilisateur saisit "Choix 1" dans le champs "Champ_Input_choix_Liste_choix"
    And l utilisateur clique sur Entree pour l ajout de choix
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_champ_cases_coucher"
    And l utilisateur saisit "Champ cases à coucher de formulaire" dans le champs "Champ_Input_champ_cases_coucher"
    And l utilisateur saisit "Case 1" dans le champs "Champ_Input_case_cases_coucher"
    And l utilisateur clique sur Entree pour l ajout de case
    And pause 5 secondes
    #And l utilisateur clique sur "Bouton_Ajouter_champ_radio"
    And l utilisateur clique sur "Bouton_Ajouter_champ_Document"
    And l utilisateur saisit "Champ document de formulaire" dans le champs "Champ_Input_champ_Document"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Valider_formulaire"
    And pause 5 secondes

    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 5 secondes

    #Etape 3 : Vérification de la création de l'évenement avec formulaire

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    And pause 5 secondes
    Then vérifier la création du nouveau evenement avec formulaire pour user externe

    #Etape 6 : Supprimer l'évenement

    And pause 5 secondes
    And l utilisateur clique sur "Bouton_options_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_evenement"