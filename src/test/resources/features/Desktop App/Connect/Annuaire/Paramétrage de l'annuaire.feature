# Auteur: BenYedder
# Feature: Annuaire
# Scénario: Paramétrage de l'annuaire
# Date de création: 04/06/2021

Feature: Annuaire - Paramétrage de l'annuaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0002
  Scenario: Paramétrage de l'annuaire

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 5 secondes
    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 5 secondes

  #Etape 2 : Acceder au rubrique parametres profil

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 5 secondes

  #Etape 3  : Ajout des informations A propos

    When l utilisateur clique sur "Date_de_naissance"
    And l utilisateur saisit "06/08/1996" dans le champs "Champ_Input_Profil_Anniversaire"
    And pause 5 secondes
    And l utilisateur saisit "58 000 000" dans le champs "Champ_Input_Profil_Phone"
    And pause 5 secondes
    And l utilisateur saisit "Ce qui compte, ce ne sont pas les coups que l'on donne, mais ceux que l'on reçoit et auxquels on résiste pour aller de l'avant." dans le champs "Champ_Input_Profil_Citation"
    And pause 5 secondes
    And l utilisateur saisit "Randy Pausch" dans le champs "Champ_Input_Profil_Auteur"
    And pause 5 secondes
    And l utilisateur saisit "Souriant, dynamique et ponctuel" dans le champs "Champ_Input_Resume"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape 4  : Ajout des informations Divers

    When l utilisateur clique sur "rubrique_divers"
    And pause 5 secondes
    And l utilisateur saisit "Sport, Nature" dans le champs "Champ_Input_Divers_Loisirs"
    And l utilisateur clique sur Entree pour ajout Loisirs
    And pause 5 secondes
    And l utilisateur saisit "Informatique" dans le champs "Champ_Input_Divers_Connaissances"
    And l utilisateur clique sur Entree pour ajout de Connaissance

  #Etape 5  : Ajout des informations Réseaux sociaux

    When l utilisateur clique sur "rubrique_Reseaux_sociaux"
    And pause 5 secondes
    And l utilisateur saisit "https://www.facebook.com/BubblePlatform" dans le champs "Champ_Input_facebook"
    And pause 5 secondes
    And l utilisateur saisit "https://www.linkedin.com/company/bubble-you-platform" dans le champs "Champ_Input_linkedin"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"

  #Etape 6  : partie activation

  #Etape 7  : Ajout photo de profile

    When l utilisateur clique sur "Username_menu"
    And l utilisateur upload photo de profil "image1" dans le champs "H_Upload_photo_de_profil"
    And pause 5 secondes
    Then vérifier que l'image est ajoutée