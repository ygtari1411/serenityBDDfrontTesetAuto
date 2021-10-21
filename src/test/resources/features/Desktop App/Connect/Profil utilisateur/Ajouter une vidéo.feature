# Auteur: BenYedder
# Feature: Profil utilisateur
# Scénario: Ajouter une vidéo
# Date de création: 06/05/2021

Feature: Profil utilisateur - Ajouter une vidéo

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-PROFILUTILISATEUR
  @WEAVIN-PROFILUTILISATEUR-0018
  Scenario: Ajouter une vidéo

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape2  : Ajout d'une vidéo

    When l utilisateur clique sur "Username_menu"
    And pause 10 secondes
    And l utilisateur clique sur "Menu_vidéos_profil"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Télécharger_vidéo"
    And pause 10 secondes
    And l utilisateur saisit "Vidéo Test" dans le champs "Champ_Input_Description_Vidéo"
    And pause 5 secondes
    And l utilisateur upload video "vidéo" dans le champs "Champ_Input_Telecharger_video"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_Sauvgarder_Vidéo"
    And pause 5 secondes


  #Etape3 : vérifier que la vidéo a été ajoutée

    And l utilisateur clique sur "Derniere_Vidéo"
    #And pause 10 secondes
    #Then vérifier que la vidéo a été ajoutée