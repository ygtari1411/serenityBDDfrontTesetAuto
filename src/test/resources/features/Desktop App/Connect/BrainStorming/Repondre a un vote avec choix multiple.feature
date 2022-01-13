# Auteur: ygtari
# Feature: BrainStorming
# Scénario: Repondre a un vote a choix multiple
# Date de création: 22/07/2021

Feature: Brainstorming - Repondre a un vote a choix multiple

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-BrainStorming
  @WEAVIN-BrainStorming-0008
  Scenario: Repondre a un vote a choix multiple

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 20 secondes

 #Etape2  : Ajout vote ou un sondage

    When l utilisateur clique sur "Bouton_BrainStorming_Menu_Gauche"
    And pause 5 secondes
    Then vérifier que la page affichée est la page BrainStorming
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Vote_Sondage"
    And pause 5 secondes
    And l utilisateur clique sur "BrainStorming_Vote"
    And pause 5 secondes
    Then vérifier que la page de vote s affiche
    And pause 5 secondes
    And l utilisateur saisit "Repondre a un vote a choix multiple" dans le champs "Champ_Input_Titre_BrainStorming"
    And pause 5 secondes
    And l utilisateur selectionne "Normal" dans la liste deroulante "Liste_Affichage_BrainStorming"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Choix_Unique_BrainStorming"
    And pause 5 secondes
    And l utilisateur saisit "Question 1 ?" dans le champs "Champ_Input_Question_BrainStorming"
    And pause 5 secondes
    And l utilisateur saisit "Information Supplementaire" dans le champs "Champ_Input_InfoSupp_BrainStorming"
    And pause 5 secondes
    And l utilisateur saisit "reponse 1" dans le champs "Champ_Input_Premiere_Reponse_BrainStorming"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Reponse_BrainStorming"
    And pause 5 secondes
    And l utilisateur saisit "reponse 2" dans le champs "Champ_Input_Deuxieme_Reponse_BrainStorming"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Vote"
    And pause 5 secondes
    And l utilisateur clique sur "Onglet_BrainStorming"
    And pause 5 secondes

  #Etape 3  : Verifier que le vote a été ajouté avec succes

    Then verifier que le vote a ete ajoute avec succes

  #Etape 4  : Lancer le vote

    And l utilisateur clique sur "Bonton_Lancer_Premier_Vote_Afficher"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 20 secondes

  #Etape 5  : Vérifier que le vote est lancé

    Then verifier que le vote est lance

  #Etape 6  : l'initiateur du vote de déconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

  #Etape 7  : Le deuxiéme utilisateur se connecte pour participer au vote

    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_BrainStorming_Menu_Gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Participez_Premier_Vote_Afficher"
    And pause 5 secondes
    And l utilisateur clique sur "Premier_Choix_Vote_Brainstorming"
    And pause 5 secondes
    And l utilisateur clique sur "Deuxieme_Choix_Vote_Brainstorming"
    And pause 5 secondes
    And l utilisateur clique sur "Envoyer_Vote_Brainstorming"

  #Etape 8  : Vérifier que le vote a été ajouté

    Then verifier que le vote est comptabilse
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_fermer_popup_Brainstorming"




