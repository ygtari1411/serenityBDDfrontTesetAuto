# Auteur: ygtari
# Feature: Compagne de don
# Scénario:Contibution a une compagne de don
# Date de création: 24/08/2021



Feature: Compagne de Don - Contribution a  une compagne de don

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-DON
  @WEAVIN-DON-0002
  Scenario: Contribution a  une compagne de don

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape 2 : Ajouter un Don

    When l utilisateur clique sur "Bouton_Don_menu_gauche"
    Then vérifier que la page afficher est la page compagne de don
    And l utilisateur clique sur "Bouton_Ajout_Compagne_De_Don"
    Then vérifier que le modal de création d'un don est affiché
    And l utilisateur saisit "Test de charge 1" dans le champs "Champ_Input_Titre_Don"
    And pause 15 secondes
    And l utilisateur ajoute une photo de couverture pour la compagne de don
    And l utilisateur saisit "Test de charge" dans le champs "Descriptif_Compagne_De_Don"
    And pause 15 secondes
    And l utilisateur saisit "31/12/2021" dans le champs "Date_Cloture_Don"
    And pause 15 secondes
    And l utilisateur saisit "23:59" dans le champs "Heure_Cloture_Don"
    And pause 15 secondes
    And l utilisateur saisit "50000" dans le champs "Objectif_Compagne_Don"
    And pause 15 secondes
    And l utilisateur saisit "150" dans le champs "Montant_Don"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_Montant_Libre"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_Montant_Collecter"
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Sauvegarder_Don"
    And pause 15 secondes
    And l utilisateur clique sur "Bouton_confirmer_action"
    And pause 15 secondes


    #Etape 3 : Vérifier que la compagne  de don et créer et lancer

    Then verifier que la campagne de don et creer et lancer

    #Etape 4 : L initiateur de la compagne de don se déconnecte

    And  l utilisateur se deconnecte
    And pause 10 secondes

   #Etape 5 : Se connecter avec un utilisateur

    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Don_menu_gauche"
    And pause 10 secondes
    Then vérifier que la page afficher est la page compagne de don
    And pause 10 secondes
    And l utilisateur clique sur "Bouton_Faire_Un_Don"
    And pause 10 secondes
    And l utilisateur clique sur "Montant_Du_Don"
    And pause 10 secondes
    And l utilisateur saisit "utilisateur" dans le champs "Titulaire_de_la_carte"
    And pause 10 secondes
    And l utilisateur saisit "424242424242424242424242424" dans le champs "Numero_Carte"
    And l utilisateur clique sur "Bouton_Valider_Un_Don"
    And pause 10 secondes
