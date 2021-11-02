# Auteur: BenYedder
# Feature: Lien utile
# Scénario: Visualiser le lien utile par un autre utilisateur (rôle Utilisateur)
# Date de création: 01/11/2021


Feature: Lien utile - Visualiser le lien utile par un autre utilisateur (rôle Utilisateur)

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-LIENUTILE
  @WEAVIN-LIENUTILE-0003
  Scenario: Visualiser le lien utile par un autre utilisateur (rôle Utilisateur)

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation Lien utile

    When l utilisateur effectue un hover sur "Username_menu"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Configuration_utilisateur"
    And pause 5 secondes
    And l utilisateur clique sur "Rubrique_Personnaliser"
    And pause 5 secondes
    And l utilisateur clique sur "Sous_Rubrique_Gestion_Liens_utiles"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Ajout_Lien_Utile"
    Then vérifier que le modal de création d'un lien utile est affiché
    And pause 5 secondes
    And l utilisateur saisit "Test automatisé Visualiser le lien utile" dans le champs "Champ_Input_Titre_Lien_Utile"
    And pause 5 secondes
    And l utilisateur saisit "https://www.steg.com.tn/fr/index.html" dans le champs "Champ_Input_Lien_Lien_Utile"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Modal_Ajouter_Lien_Utile"

      #Etape 3 : verification de la création d'un lien utile

    And pause 7 secondes
    And l utilisateur saisit "Test automatisé Visualiser le lien utile" dans le champs "Champ_Input_Rechercher_Lien_Utile"
    Then Vérifier que le lien utile est publié

    #Etape 4 : l'utilisateur Marc se deconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

    #Etape 5 : Le deuxieme utilisateur se connecte  pour accepter l'evenement et remplir le formulaire

    And l'utilisateur "yassine.gtari@advyteam.com" est connecté
    And pause 4 secondes
    And l utilisateur clique sur "Bouton_List_Lien_Utile"
    Then vérifier que le lien utile est visible