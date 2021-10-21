# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter un numéro de téléphone
# Date de création: 01/03/2021

Feature: Profil utilisateur - Ajouter un numéro de téléphone

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0005
  Scenario: Ajouter un numéro de téléphone

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "58 000 000" dans le champs "Champ_Input_Profil_Phone"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape3  vérifier que le numéro de téléphone a été ajouté

    #Then vérifier que le numéro de téléphone a été ajouté


