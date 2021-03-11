# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Commenter et liker un album
# Date de création: 11/03/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0011
  Scenario: Commenter et liker un album

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
    And l utilisateur saisit "Ceci est un test automatique pour commenter et liker un album" dans le champs "Champ_Input_Description_Album"
    And pause 5 secondes
    And l utilisateur upload photo "image2" dans l album' "Photo_attache_nouvel_Album"
    And pause 20 secondes
    And l utilisateur clique sur "Bouton_Publier_Album"
    And pause 15 secondes

  #Etape3 : vérifier que l album a été ajouté

    And l utilisateur clique sur "Derniere_Album"
    And pause 10 secondes
    Then vérifier que l album a été ajouté

  #Etape 4 : Commenter un album

    And l utilisateur clique sur "Bouton_Repondre_Album"
    And l utilisateur saisit "test automatisé commenter et Liker un album" dans le champs "Champ_Input_Commenter_Album"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_Commenteraire_Album"
    And pause 10 secondes
    Then vérifier l ajout  correct du commentaire album

  #Etape 5 : Liker un album

    And l utilisateur clique sur "Bouton_aime_Album"
    And pause 20 secondes
    Then vérifier l ajout  correct du Like album