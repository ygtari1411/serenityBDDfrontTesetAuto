# Auteur: BenYedder
# Feature: Gestion des catégories
# Scénario: Modifier des catégories "Opportunités"
# Date de création: 02/11/2021

Feature: Gestion des catégories - Modifier des catégories "Opportunités"

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-GESTIONCATEGORIES
  @WEAVIN-GESTIONCATEGORIES-0002
  Scenario: Modifier des catégories "Opportunités"


  #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté
    And pause 10 secondes

  #Etape 2 : Ajout catégorie opportunité

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Personnaliser"
    And pause 5 secondes
    And l utilisateur clique sur "Sous_Rubrique_Gestion_Catégories"
    And l utilisateur clique sur "Bouton_Ajout_Catégorie_Opportunité"
    And l utilisateur saisit "Test auto Modifier catégorie opportunité" dans le champs "Champ_Input_Catégorie_Opportunité"
    And l utilisateur clique sur "Bouton_Enregistrer_Catégorie_Opportunité"
    # Vérification

  #Etape 2 : Modification catégorie opportunité

    And l utilisateur clique sur "Bouton_Options_Catégorie_Opportunité"
    And l utilisateur clique sur "Bouton_Modifier_Catégorie_Opportunité"
    And l utilisateur saisit "catégorie opportunité modifiée" dans le champs "Champ_Input_Catégorie_Opportunité"
    And l utilisateur clique sur "Bouton_Enregistrer_Catégorie_Opportunité"
    # Vérification