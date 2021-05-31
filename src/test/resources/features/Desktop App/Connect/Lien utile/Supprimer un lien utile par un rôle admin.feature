# Auteur: BenYedder
# Feature: Lien utile
# Scénario: Supprimer un lien utile par un rôle admin
# Date de création: 02/04/2021


Feature: Supprimer un lien utile par un rôle admin

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-LIENUTILE
  @WEAVIN-LIENUTILE-0002
  Scenario: Supprimer un lien utile par un rôle admin

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
    And l utilisateur saisit "Test automatisé Ajout Lien Utile STEG" dans le champs "Champ_Input_Titre_Lien_Utile"
    And pause 5 secondes
    And l utilisateur saisit "https://www.steg.com.tn/fr/index.html" dans le champs "Champ_Input_Lien_Lien_Utile"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Modal_Ajouter_Lien_Utile"

      #Etape 3 : verification de la création d'un lien utile

    And pause 7 secondes
    And l utilisateur saisit "Test automatisé Ajout Lien Utile STEG" dans le champs "Champ_Input_Rechercher_Lien_Utile"
    Then Vérifier que le lien utile est publié

     #Etape 4 : Suppression d'un lien utile

    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Lien_Utile"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    Then vérifier que le message "Supprimé !" s'affiche dans la notification
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 5 secondes
    And l utilisateur saisit "" dans le champs "Champ_Input_Rechercher_Lien_Utile"
    And pause 5 secondes
    And l utilisateur Vider le champ de rechercher Lien utile
    And pause 10 secondes
    Then Vérifier que le lien utile est supprimé

