# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Ajouter les reseaux sociaux
# Date de création: 25/01/2022

Feature: Profil utilisateur - Ajouter les reseaux sociaux

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0025
  Scenario: Ajouter les reseaux sociaux

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'une citation

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 20 secondes
    And l utilisateur clique sur "Menu_parametres_profil"
    And pause 10 secondes
    And l utilisateur clique sur "rubrique_reseaux_sociaux"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Parametre_Compte"


  #Etape3  vérifier que les reseaux sociaux ont ete ajoute

    Then vérifier que le message "Les réseaux sociaux sont mis à jour !" s'affiche dans la notification


