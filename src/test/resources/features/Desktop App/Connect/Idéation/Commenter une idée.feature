# Auteur: ygtari
# Feature: Idéation
# Scénario: Commenter une idée
# Date de création: 08/12/2020



Feature: Idéation - Commenter une idée

   @WEAVIN
   @WEAVIN-CONNECT
   @WEAVIN-IDEATION
   @WEAVIN-IDEATION-0004
  Scenario: Commenter une idée

    #Etape 1 : Connexion

     Given le navigateur est ouvert et la page d'acceuil est affichée
     And l'utilisateur "marc.parenteau@yopmail.com" est connecté

    #Etape2  : Ajout idée

     And l utilisateur clique sur "Bouton_ideation_menu_gauche"
     Then vérifier que la page affichée est la page idéation
     When l utilisateur clique sur "Buton_ajout_ideation"
     Then vérifier que le modal de création d'une idée est affiché
     When l utilisateur saisit "test automatisé  commenter idée" dans le champs "Titre_nouvelle_idee"
     And l utilisateur saisit "idée_test_auto" dans le champs "Tag_nouvelle_idee"
     And l utilisateur saisit "Ceci est la description de l'idée publiée par un test auto" dans le champs "Description_nouvelle_idee"
     And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_idee"
     And l utilisateur upload "image2" dans le champs "Fichier_attache_nouvelle_idee"
     And l utilisateur clique sur "Bouton_enregistrer_nouvelle_idee"
     Then vérifier que le message "Opération effectuée avec succès" s'affiche dans la notification
     And pause 3 secondes

      #Etape 3 : Vérification de la création de l'idée

      Then vérifier la publication correct de l idee
      And l utilisateur saisit "test automatisé  commenter et Liker une idée" dans le champs "Champ_Input_Rechercher_Ideation_Par_Titre"
      And pause 10 secondes

     #Etape 4 : Commenter  l'idée

      When l utilisateur clique sur "Derniere_Idee_Ajoutee"
      And pause 5 secondes
      And l utilisateur clique sur "Bouton_Commenter_Ideation"
      And l utilisateur saisit "test automatisé commenter et Liker une idée" dans le champs "Champ_Input_Commenter_Ideation"
      And pause 10 secondes
      And l utilisateur clique sur "Envoyer_Commenteraire_Ideation"
      And pause 10 secondes
      Then vérifier l ajout  correct du commentaire

