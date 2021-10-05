# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Modifier le commentaire et le like d'un album
# Date de création: 05/10/2021

Feature: Profil utilisateur

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0021
  Scenario: Modifier le commentaire et le like d'un album

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
    And l utilisateur saisit "Ceci est un test automatique pour modifier le commentaire et le like d'un album" dans le champs "Champ_Input_Description_Album"
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
    And l utilisateur saisit "test automatisé modifier le commentaire et le like d'un album" dans le champs "Champ_Input_Commenter_Album"
    And pause 10 secondes
    And l utilisateur clique sur "Envoyer_Commenteraire_Album"
    And pause 10 secondes
    #Then vérifier l ajout  correct du commentaire album

  #Etape 5 : Liker un album

    And l utilisateur clique sur "Bouton_aime_Album"
    And pause 20 secondes
    #Then vérifier l ajout correct du Like album


  #Etape 5 : Modifier le commentaire

    #When l utilisateur clique sur "Icone_Commentaire_Evenement"
    #And pause 20 secondes
    And l utilisateur effectue un hover sur "Bouton_Option_Commentaire"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Editer_Commentaire"
    And pause 15 secondes
    And l utilisateur modifie "commentaire modifiée" dans le champs "Champ_Input_Modification_Commenteraire"
    And pause 5 secondes
    #And l utilisateur clique sur "Envoyer_Commenteraire_Modifier_Evenement"
    And l utilisateur clique sur le bouton Envoyer_Commenteraire_Modifier_Evenemeent
    And pause 10 secondes
    Then verifier que le commentaire de l evenement est modifié


    #Etape 6 : Modifier l'interaction

    When l utilisateur effectue un hover sur "Bouton_Interaction_Evenement"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Praise"
    And pause 10 secondes
    Then verifier que l'interaction de l évenement a été modifiée avec succés
