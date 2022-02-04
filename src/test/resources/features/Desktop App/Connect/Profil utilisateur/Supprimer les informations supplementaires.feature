# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Supprimer les information supplementaire
# Date de création: 26/02/2021

Feature: Profil utilisateur - Supprimer les information supplementaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0033
  Scenario: Supprimer les information supplementaire

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une information supplémentaire

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur clique sur "rubrique_information_supplementaire"
    And pause 20 secondes
    And l utilisateur saisit "ceci est un test automatique de l ajout d une information supplementaire" dans le champs "Champ_Input_information_supplementaire"
    And l utilisateur clique sur "enregistrer_information_supplementaire"

  #Etape3 : verifier que l'information supplementaire a etait ajouté avec succes

    Then vérifier que le message "Mise à jour des informations supplémentaires du profil !" s'affiche dans la notification

 #Etape 4 : Supprimer une information supplementaire

    And l utilisateur modifie "ceci est un test automatique de l ajout d une information supplementaire" dans le champs "Champ_Input_information_supplementaire"

  #Etape 5 : Enregistrer les modification

    And l utilisateur clique sur "enregistrer_information_supplementaire"
    Then vérifier que le message "Mise à jour des informations supplémentaires du profil !" s'affiche dans la notification

