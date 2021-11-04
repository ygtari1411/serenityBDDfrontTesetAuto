# Auteur: BenYedder
# Feature: Lien utile
# Scénario: Ajouter un lien utile à travers la barre horizontale
# Date de création: 02/11/2021


Feature: Lien utile - Ajouter un lien utile à travers la barre horizontale

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-LIENUTILE
  @WEAVIN-LIENUTILE-0004
  Scenario: Ajouter un lien utile à travers la barre horizontale

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation Lien utile

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_List_Lien_Utile"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajouter_Lien_Utile_HB"
    Then vérifier que le modal de création d'un lien utile est affiché
    And pause 5 secondes
    And l utilisateur saisit "Test automatisé Ajout Lien Utile SONEDE" dans le champs "Champ_Input_Titre_Lien_Utile"
    And pause 5 secondes
    And l utilisateur saisit "https://www.sonede.com.tn/" dans le champs "Champ_Input_Lien_Lien_Utile"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Modal_Ajouter_Lien_Utile"

      #Etape 3 : verification de la création d'un lien utile

    And pause 7 secondes
    And l utilisateur clique sur "Bouton_List_Lien_Utile"
    #Then vérifier que le lien utile est ajouté