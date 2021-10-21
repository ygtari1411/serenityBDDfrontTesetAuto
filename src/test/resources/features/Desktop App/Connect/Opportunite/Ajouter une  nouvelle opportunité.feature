# Auteur: YGtari
# Feature: Opportunite
# Scénario: Ajouter dune nouvelle opportunite
# Date de création: 26/06/2021




Feature: Opportunite - Ajouter d une nouvelle opportunite


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-OPPORTUNITE
  @WEAVIN-OPPORTUNITE-0002
  Scenario: Ajouter d une nouvelle opportunite

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
    And l utilisateur saisit "Publier une opportunité" dans le champs "Description_Categorie_Opportunite"
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

