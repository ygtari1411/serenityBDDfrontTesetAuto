# Auteur: BenYeder
# Feature: Journalisation
# Scénario: Supprimer un évènement
# Date de création: 19/08/2021


Feature: Journalisation

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-JOURNALISATION
  @WEAVIN-JOURNALISATION-0006
  Scenario: Supprimer un évènement

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 5 secondes

  #Etape2  : Ajout un évènement

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
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"
    And pause 5 secondes

  #Etape 3 : Vérification de la création de l'évènement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement

  #Etape 4 : Suppresion de l'évènement

    And l utilisateur clique sur "Bouton_options_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_supprimer_evenement"


  #Etape 6 : Verifier la suppression dans la journalisation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Corbeille"
    And pause 10 secondes
    Then vérifier que le modal de Gestion des publications est affiché
    And pause 20 secondes
    Then vérifier que l evenement supprimé est affiché dans la liste corbeille publications
