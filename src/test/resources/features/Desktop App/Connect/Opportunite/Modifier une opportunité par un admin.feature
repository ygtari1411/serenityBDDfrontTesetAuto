# Auteur: YGtari
# Feature: Opportunite
# Scénario:Modifier une opportunité par un admin
# Date de création: 26/06/2021




Feature: Opportunite - Modifier une opportunité par un admin


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-OPPORTUNITE
  @WEAVIN-OPPORTUNITE-0004
  Scenario: Modifier une opportunité par un admin

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
     And l utilisateur saisit "Modifier une opportunité par un admin" dans le champs "Description_Categorie_Opportunite"
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

   #Etape 5 : l'utilisateur admin se connecte

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    When l utilisateur clique sur "Bouton_Opportunite_menu_gauche"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Option_Opportunite"
    And pause 20 secondes

   #Etape 6 : vérifer que L'admin ne peut pas modifier l'ooportunité

    Then vérifer que L admin ne peut pas modifier l oportunité



