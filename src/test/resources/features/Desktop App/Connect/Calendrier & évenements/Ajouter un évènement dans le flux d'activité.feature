# Auteur: BenYedder
# Feature: Calendrier & évenements
# Scénario: Ajouter un évènement dans le flux d'activité
# Date de création: 29/04/2021


Feature: Calendrier & évenements

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-CALENDRIER&EVENEMENTS
  @WEAVIN-CALENDRIER&EVENEMENTS-0014
  Scenario: Ajouter un évènement dans le flux d'activité

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

    #Etape 2 : Ajout évenement

    When l utilisateur clique sur "Bouton_calendrier_menu_gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page calendrier et évenement
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajout_Evenement"
    And pause 5 secondes
    Then vérifier que le modal de création d'un evenement est affiché
    And pause 5 secondes
    #And l utilisateur selectionne "Marc Parenteau" dans la liste deroulante "Calendrier"
    #And l utilisateur selectionne "PUBLIC" dans la liste deroulante "Type_Evenement"
    And l utilisateur saisit "Test automatique Ajouter un évènement dans le flux d'activité" dans le champs "Champ_Input_Titre_Evenement"
    And l utilisateur saisit "C'est un test automatique de l'Ajout d'un évènement dans le flux d'activité" dans le champs "Champ_Input_Description_Evenement"
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
    And l utilisateur saisit "Nasser QA" dans le champs "Champ_Input_invites_interne_evenement"
    And pause 10 secondes
    And l utilisateur clique sur "Invite_interne_evenement_selectionne"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Invite_interne_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_creer_evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Non_envoi_mail_evenement"

    #Etape 3 : Vérification de la création de l'évenement

    When l utilisateur clique sur "Evenement_Dans_Calendrier"
    Then vérifier la création du nouveau evenement dans le flux d'activité
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Fermer_Evenement"
    And pause 5 secondes

    #Etape 4 : l'utilisateur Marc se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

    #Etape 5 : Le deuxieme utilisateur se connecte  pour verifier l'evenement dans le flux d'activité

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    Then vérifier l ajout de l evenement dans le flux d'activité
