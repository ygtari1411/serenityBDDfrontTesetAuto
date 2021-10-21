# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Modifier une citation
# Date de création: 25/02/2021

Feature: Profil utilisateur - Modifier une citation

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0004
  Scenario: Modifier une citation

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "ceci est un test automatique de l ajout d une citation" dans le champs "Champ_Input_Profil_Citation"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape3:  vérifier que la citation a été ajouté

    Then vérifier que la citaiton a été ajouté

  #Etape4:  vérifier que la citation a été ajouté

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur modifie "citation modifiée" dans le champs "Champ_Input_Profil_Citation"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape5:  vérifier que la citation a été modifiée

   Then verifier que la citation a été modifiée
