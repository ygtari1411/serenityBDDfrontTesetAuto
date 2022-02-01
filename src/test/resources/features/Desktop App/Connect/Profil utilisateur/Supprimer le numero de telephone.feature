# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Supprimer le numéro de téléphone
# Date de création: 01/02/2022

Feature: Profil utilisateur - Supprimer le numéro de téléphone

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0030
  Scenario: Supprimer le numéro de téléphone

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "01 01 63 79 31" dans le champs "Champ_Input_Profil_Phone"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes

  #Etape3  : Supprimer le numero de telephone

    And l utilisateur modifie "" dans le champs "Champ_Input_Profil_Phone"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"
    And pause 20 secondes


