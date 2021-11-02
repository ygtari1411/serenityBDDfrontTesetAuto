# Auteur: BenYedder
# Feature: Adminstration et Configuration
# Scénario: Longue par défaut
# Date de création: 28/10/2021


Feature: Adminstration et Configuration - Longue par défaut

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ADMINCONFIG
  @WEAVIN-ADMINCONFIG-0001
  Scenario: Longue par défaut

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Accéder au rubrique Personnaliser

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Personnaliser"
    And pause 5 secondes
    And l utilisateur clique sur "Sous_Rubrique_Parametres_generaux"
    And pause 5 secondes