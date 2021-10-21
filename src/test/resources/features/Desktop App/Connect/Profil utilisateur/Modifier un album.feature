# Auteur: ygtari
# Feature: Profil utilisateur
# Scénario: Modifier un album
# Date de création: 08/03/2021

Feature: Profil utilisateur - Modifier un album

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0008
  Scenario: Modifier un album

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape2  : Ajout d'un album

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_photos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Ajout_Album"
    And pause 10 secondes
    And l utilisateur saisit "Album Test" dans le champs "Champ_Input_Titre_Album"
    And pause 5 secondes
    And l utilisateur saisit "Ceci est un test automatique de la modification d un album" dans le champs "Champ_Input_Description_Album"
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

    And l utilisateur clique sur "Bouton_Fermer_Derniere_Album"
    And pause 5 secondes
    And l utilisateur effectue un hover sur "Derniere_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Options_Album"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Mettre_Ajour_Album"
    And pause 5 secondes
    And l utilisateur saisit "Album Test Modifié" dans le champs "Champ_Input_Titre_Album"
    And pause 5 secondes
    And l utilisateur saisit "Description d un album Modifiée" dans le champs "Champ_Input_Description_Album"
    And pause 5 secondes
    And l utilisateur upload photo "image1" dans l album' "Photo_attache_nouvel_Album"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    And pause 15 secondes

  #Etape5 : vérifier que l album a été modifié

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    Then vérifier que l album a été modifié
