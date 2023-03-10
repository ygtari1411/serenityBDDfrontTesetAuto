# Auteur: YGtari
# Feature: Opportunite
# Scénario: Commenter une opportunite
# Date de création: 05/07/2021




Feature: Opportunite - Commenter une opportunite


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-OPPORTUNITE
  @WEAVIN-OPPORTUNITE-0006
  Scenario: Commenter une opportunite

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Publier une opportunite
    #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
    When l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 10 secondes
    And l utilisateur clique sur "Publier_Une_Opportnite"
    And pause 5 secondes
    And l utilisateur saisit "Voiture" dans le champs "Champ_input_titre_Opportunite"
    And pause 5 secondes
    And l utilisateur selectionne "Opportunité" dans la liste deroulante "Liste_Category_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "Commenter une opportunite" dans le champs "Description_Categorie_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "leonel.cruse@yopmail.com" dans le champs "email_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "voiture" dans le champs "Liste_tag_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "33655664422" dans le champs "tel_Opportunite"
    And pause 5 secondes
    And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
    And pause 20 secondes
    And l utilisateur clique sur "Sauvegarder_Opportunite"
    And pause 40 secondes
    #Etape 3 : Verifier que l'opportunite a été ajouté

    Then verifier que l opportunite a ete ajoute

   #Etape 4 : l'initiateur se déconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

   #Etape 5 : Le deuxieme utilisateur se connecte pour commenter l'opportunite

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    And  l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 10 secondes
    And  l utilisateur clique sur "Premiere_Opportunite_Afficher"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Repondre_Opportunité"
    And pause 5 secondes
    And l utilisateur saisit "commenter un opportunité" dans le champs "champ_commentaire_opportunite"
    And pause 10 secondes
    And  l utilisateur clique sur "Bouton_Envoyer_Commentaire_Opportinite"

   #Etape 5 : Le premiere utilisateur se reconnecte pour verifier que le like a été comptaiblise

    And  l utilisateur se deconnecte
    And pause 10 secondes
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes
    And  l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 20 secondes

    #Etape 6 : vérifier que le like a été comptabilisé

    Then vérifier que le commentaire a ete comptabilise


