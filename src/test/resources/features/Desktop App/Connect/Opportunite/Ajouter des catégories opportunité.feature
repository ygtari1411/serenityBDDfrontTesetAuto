# Auteur: YGtari
# Feature: Opportunite
# Scénario: Ajouter des catégories opportinités
# Date de création: 26/06/2021




Feature: Article


  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-OPPORTUNITE
  @WEAVIN-OPPORTUNITE-0001
  Scenario: Ajouter des catégories opportinités

  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

  #Etape 2 : Accéder a la rubrique configuration

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Personnaliser"
    And pause 5 secondes
    And l utilisateur clique sur "Gestion_Categorie"
    And pause 5 secondes

  #Etape 3 : Ajouter une categorie d'Opportunite

    And l utilisateur clique sur "Bouton_Ajouter_CAtegorie_Opportunite"
    And pause 5 secondes
    And l utilisateur saisit "Voiture" dans le champs "Nom_Categorie_Opportunite"
    And pause 5 secondes
    And l utilisateur clique sur "Enregistrer_Gestion_Categorie"

  #Etape 3 : Vérifier que la catégorie a été ajoutée

   Then vérifier que le message "Catégorie ajoutée avec succès" s'affiche dans la notification
