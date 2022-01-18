# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Ajouter les informations supplementaires
# Date de création: 18/01/2022

Feature: Profil utilisateur - Ajouter une citation

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0023
  Scenario: Ajouter les informations supplementaires

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une information supplémentaire

    When l utilisateur effectue un hover sur "Username_menu"
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "Rubrique_Personnaliser"
    And pause 10 secondes
    And l utilisateur clique sur "Sous_Rubrique_Parametres_Profil_Utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Champ_information"
    And pause 10 secondes
    And l utilisateur saisit "infoSupp" dans le champs "titre_nouveau_champ_profil_utilisateur"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_information_supplementaire"

  #Etape3  : verifier que l information supplementaire a ete ajouté

    #Then vérifier que le message "Mise à jour des Champs avec succès" s'affiche dans la notification