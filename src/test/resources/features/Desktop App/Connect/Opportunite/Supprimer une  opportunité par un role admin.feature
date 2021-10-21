# Auteur: YGtari
# Feature: Opportunite
# Scénario: Supprimer une opportunité par un role admin
# Date de création: 08//07/2021




Feature: Opportunite - Supprimer une opportunité par un role admin


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-OPPORTUNITE
  @WEAVIN-OPPORTUNITE-0007
  Scenario: Supprimer une opportunité par un role admin

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Publier une opportunite

    When l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 5 secondes
    And l utilisateur clique sur "Publier_Une_Opportnite"
    And pause 5 secondes
    And l utilisateur saisit "Voiture" dans le champs "Nom_Categorie_Opportunite_Menu_Gauche"
    And pause 5 secondes
    And l utilisateur selectionne "Opportunité" dans la liste deroulante "Liste_Category_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "supprimer une opportunite par un admin" dans le champs "Description_Categorie_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "leonel.cruse@yopmail.com" dans le champs "email_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "voiture" dans le champs "Liste_tag_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "33655664422" dans le champs "tel_Opportunite"
    And pause 5 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And pause 60 secondes
    And l utilisateur clique sur "Sauvegarder_Opportunite"

  #Etape 3 : Verifier que l'opportunite a été ajouté

    Then verifier que l opportunite a ete ajoute

  #Etape 4 : l'initiateur se déconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

   #Etape 5 : l'utilisateur admin se connecte

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Option_Opportunite"
    And pause 10 secondes

   #Etape 6 : l'admin supprime l'opportunite

    And l utilisateur clique sur "Bouton_Option_Supprimer_Opportunite"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Confirmer_Supprimer_Opportunite"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"

  #Etape 6 : l'admin supprime l'opportunite

    Then verifier que l opportunite a ete supprime
