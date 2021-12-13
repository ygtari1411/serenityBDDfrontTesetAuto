# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter une date d'anniversaire
# Date de création: 15/07/2021

Feature: Profil utilisateur - Ajouter une date d'anniversaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNIVERSAIRE
  @WEAVIN-ANNIVERSAIRE-0001
  Scenario: Ajouter une date d'anniversaire

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté

  #Etape2  : Ajout d'une date d'anniversaire

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "05/08/1996" dans le champs "Champ_Input_Profil_Anniversaire"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes
    And l utilisateur clique sur "Username_menu"

  #Etape3  vérifier que la date d'anniversaire a été e

    Then vérifier que la date d anniversaire a été ajoutée


