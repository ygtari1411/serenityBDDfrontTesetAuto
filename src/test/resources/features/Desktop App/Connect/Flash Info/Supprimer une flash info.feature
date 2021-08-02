# Auteur: ygtari
# Feature: Flash Info
# Scénario:Supprimer une Flash Info
# Date de création: 27/07/2021



Feature: Flash Info

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-FLASHINFO
  @WEAVIN-FLASHINFO-0003
  Scenario: Supprimer une flash info

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape 2 : Ajouter une Flash Info

    When verifier que le widget flash info apparait
    And l utilisateur clique sur "Bouton_Ajouter_Flash_Info"
    And pause 5 secondes
    And l utilisateur saisit "Supprimer une Flash Info" dans le champs "titre_flash_info"
    And pause 5 secondes
    And l utilisateur saisit "test auto ajouter une flash info" dans le champs "description_flash_info"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Flash_Info"
    And pause 5 secondes

    #Etape 3 : Supprimer Flash Info

    And l utilisateur clique sur "Bouton_Option_Flash_Info"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Supprimer_Flash_Info"
    And pause 5 secondes

    #Etape 4 : Verifier que la Flash Info a ete supprime

    Then verifier que la flash info a ete supprime


