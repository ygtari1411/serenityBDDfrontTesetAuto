# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Ajouter une date de naissance
# Date de création: 17/01/2022

Feature: Profil utilisateur - Ajouter une date de naissance

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0022
  Scenario: Ajouter une date de naissance

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout d'une date de naissance

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur saisit "06/08/1996" dans le champs "profil_utilisateur_date_anniversaire"
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"


  #Etape3  vérifier que la date d anniversaire ete ajoute

    Then vérifier que le message "Mise à jour des informations de profil !" s'affiche dans la notification

