# Auteur: ygtari
# Feature: Flash Info
# Scénario:Ajouter une Flash Info
# Date de création: 27/07/2021



Feature: Flash Info - Ajouter une Flash Info

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-FLASHINFO
  @WEAVIN-FLASHINFO-0001
  Scenario: Ajouter une Flash Info

    #Etape 1 : Connexion

    Given le navigateur est ouvert et la page d'acceuil est affichée
    And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape 2 : Ajouter une Flash Info

    When verifier que le widget flash info apparait
    And l utilisateur clique sur "Bouton_Ajouter_Flash_Info"
    And pause 5 secondes
    And l utilisateur saisit "Ajouter une Flash Info" dans le champs "titre_flash_info"
    And pause 5 secondes
    And l utilisateur saisit "test auto ajouter une flash info" dans le champs "description_flash_info"
    And pause 5 secondes
    And l utilisateur clique sur "Bouton_Enregistrer_Flash_Info"
    And pause 5 secondes

    #Etape 3 : Se connecter avec le ueser 2 est vérifier que la flash info apparait pour les autre utilisateur

    And  l utilisateur se deconnecte
    And pause 10 secondes
    And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
    And pause 10 secondes
    And verifier que la flash info apparait pour les autre utilisateur


