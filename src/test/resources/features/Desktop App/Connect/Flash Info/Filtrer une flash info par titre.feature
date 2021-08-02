# Auteur: ygtari
# Feature: Flash Info
# Scénario:Filtrer une Flash Info par titre
# Date de création: 27/07/2021



Feature: Flash Info

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-FLASHINFO
  @WEAVIN-FLASHINFO-0002
  Scenario: Filtrer une Flash Info par titre

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape 2 : Ajouter une Flash Info

    When verifier que le widget flash info apparait
    And l utilisateur clique sur "Bouton_Ajouter_Flash_Info"
    And pause 5 secondes
    And l utilisateur saisit "Filtrer une Flash Info par titre" dans le champs "titre_flash_info"
    And pause 5 secondes
    And l utilisateur saisit "test auto ajouter une flash info" dans le champs "description_flash_info"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Flash_Info"
    And pause 5 secondes

    #Etape 3 : Rechercher La flash info par titre

    And l utilisateur clique sur "Bouton_Voir_Tous_Flash_Info"
    And pause 5 secondes
    And l utilisateur saisit "Filtrer une Flash Info par titre" dans le champs "Rechercher_Flash_Info_Par_Titre"
    And pause 5 secondes
    Then verifier que la flash info afficher est c elle qui est rechercher




