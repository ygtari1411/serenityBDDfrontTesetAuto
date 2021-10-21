# Auteur: ygtari
# Feature: Idéation
# Scénario:Créer une idée avec des champs vides
# Date de création: 22/12/2020



Feature: Idéation - Créer une idée avec des champs vides

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-IDEATION
  @WEAVIN-IDEATION-0015
  Scenario: Créer une idée avec des champs vides

     #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape2  : Ajout idée

    And l utilisateur clique sur "Bouton_ideation_menu_gauche"
    Then vérifier que la page affichée est la page idéation
    And l utilisateur clique sur "Buton_ajout_ideation"
    Then vérifier que le modal de création d'une idée est affiché
    When l utilisateur saisit "" dans le champs "Titre_nouvelle_idee"
    And l utilisateur saisit "" dans le champs "Tag_nouvelle_idee"
    And l utilisateur saisit "" dans le champs "Description_nouvelle_idee"
    And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
    And vérifier qu un message d'erreur s affiche pour chaque champs requis
    And pause 10 secondes


