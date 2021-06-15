# Auteur: ygtari
# Feature: Annuaire
# Scénario: Un utilisateur désactiver n'apparait pas dans la rubrique annuaire
# Date de création: 15/06/2021



Feature: Annuaire

  @WEAVIN
  @WEAVIN-CONNECT
  @WEAVIN-ANNUAIRE
  @WEAVIN-ANNUAIRE-0004
  Scenario: Un utilisateur désactiver n'apparait pas dans la rubrique annuaire


      #Etape 1 : Connexion

      Given le navigateur est ouvert et la page d'acceuil est affichée
      And pause 5 secondes
      And l'utilisateur "mohamed.benyedder@advyteam.com" est connecté
      And pause 5 secondes

    #Etape 2 : Accéder au rubrique Gestion utilisateurs

      When l utilisateur effectue un hover sur "Username_menu"
      And pause 5 secondes
      And l utilisateur clique sur "Bouton_Configuration_utilisateur"
      And pause 5 secondes
      And l utilisateur clique sur "Rubrique_utilisateurs"
      And pause 15 secondes
      Then vérifier que le modal de Gestion des comptes est affiché
      And pause 5 secondes


    #Etape 3 : Rechercher L'utilisateur a  désactiver

      And l utilisateur saisit "yassine" dans le champs "Champ_Input_Chercher_des_membres"
      And pause 15 secondes

    #Etape 4 :Desactivation de l'utilisateur

      And l utilisateur clique sur "Bouton_Desactiver_Utilisateur"
      And pause 5 secondes
      And l utilisateur clique sur "Bouton_annuaire_menu_gauche"
      And pause 5 secondes

   #Etape 5 :Rechercher par nom et vérifier que la carte de visite  de l'utilsateur  n'apparait pas

      And l utilisateur saisit "yassine" dans le champs "Champ_Input_Chercher_des_membres_Rubrique_Annuaire"
      And pause 5 secondes
      Then verifier que la carte visite de l'utilisateur"yassine" n apparait pas dans l annuaire


   #Etape 6 :réactiver l'utilisateur

      And l utilisateur effectue un hover sur "Username_menu"
      And pause 5 secondes
      And l utilisateur clique sur "Bouton_Configuration_utilisateur"
      And pause 5 secondes
      And l utilisateur clique sur "Rubrique_utilisateurs"
      And pause 5 secondes
      Then vérifier que le modal de Gestion des comptes est affiché
      And pause 5 secondes
      And l utilisateur clique sur "Rubrique_utilisateurs"
      And pause 20 secondes
      And l utilisateur clique sur "Onglet_inactif_utilisateur"
      And pause 5 secondes
      And l utilisateur clique sur "Bouton_Reactiver_Utilisateur"

   #Etape 7 :rechercher la carte de visite de  l utilisateur dans la rubrique annuaire

     And l utilisateur clique sur "Bouton_annuaire_menu_gauche"
     And pause 5 secondes
     And l utilisateur saisit "yassine" dans le champs "Champ_Input_Chercher_des_membres_Rubrique_Annuaire"
     And pause 5 secondes

   #Etape 8 :Vérifier que la carte visite s'affiche

    Then verifier que la carte visite de l'utilisateur "Yassine" s affiche
