# Auteur: ygtari
# Feature: Timeline
# Scénario: Ajouter une publication restreinte par connaissance et par loisir
# Date de création: 14/10/2020



Feature: Timeline - Ajouter une publication restreinte par connaissance et par loisir

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-TIMELINE
  @WEAVIN-TIMELINE-0024
  Scenario: Ajouter une publication restreinte par connaissance et par loisir

      #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

      #Etape 2 : Creation statut

    And l utilisateur saisit "Test automatisé publication statut" dans le champs "champ_statut"

    #Etape 3 : ajout des restriction

    And l utilisateur clique sur "Ajouter_Restriction_Timeline"
    And pause 10 secondes
    And l utilisateur selectionne "Test loisirs à supprimer" dans la liste deroulante "Liste_Restriction_Timline_Par_Loisir"
    And pause 10 secondes
    And l utilisateur selectionne "Informatique" dans la liste deroulante "Liste_Restriction_Timline_Par_Connaissance"
    And l utilisateur clique sur "Bouton_Ajouter_Restriction_Timeline"
    And pause 10 secondes


      #Etape 3 : verification de la création d'un statut
    And l utilisateur clique sur "bouton_publier_statut"
    And pause 10 secondes
    Then Vérifier que le statut est publié