# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Vider un album
# Date de création: 09/03/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0010
  Scenario: Vider un album

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "admin" est connecté

  #Etape2  : Ajout d'un album

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_photos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_Album"
    And pause 10 secondes
    And l utilisateur saisit "Album Test" dans le champs "Champ_Input_Titre_Album"
    And pause 5 secondes
    And l utilisateur saisit "Ceci est un test automatique de vider un album" dans le champs "Champ_Input_Description_Album"
    And pause 5 secondes
    And l utilisateur upload photo "image2" dans l album' "Photo_attache_nouvel_Album"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    And pause 15 secondes


  #Etape3 : vérifier que l album a été ajouté

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    Then vérifier que l album a été ajouté

  #Etape4 : Modifier  l album  ajouté

    And l utilisateur clique sur "Bouton_Femer_Derniere_Album"
    And pause 5 secondes
    And l utilisateur effectue un hover sur "Derniere_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Options_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Mettre_Ajour_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Photo_d_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_annuler_photo"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And l utilisateur clique sur "Bouton_confirmer_action"

  #Etape5 : vérifier que l album a été supprimé

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    Then vérifier que l album a été supprimé
