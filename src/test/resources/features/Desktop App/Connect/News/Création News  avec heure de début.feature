# Auteur: YGtari
# Feature: News
# Scénario: Création nouvelle news avec heure de début
# Date de création: 09/11/2020


@WEAVIN
@WEAVIN-CONNECT
@WEAVIN-NEWS
@WEAVIN-NEWS-0002

Feature: News


  Scenario: Création nouvelle news avec heure de début

   #Etape 1 : Connexion

     Given le navigateur est ouvert et la page d'acceuil est affichée
     And l'utilisateur "admin" est connecté

   #Etape2  : Ajout News

     #When l utilisateur clique sur "Bouton_ouvrir_menu_gauche"
     And l utilisateur clique sur "Bouton_news_menu_gauche"
     Then vérifier que la page affichée est la page news
     And l utilisateur clique sur "Bouton_Ajout_News"
     Then vérifier que le modal de création d'une news est affiché
     And l utilisateur saisit "Test automatique création news avec heure début" dans le champs "Champ_Input_Titre_News"
     And l utilisateur saisit "C'est un test automatique de l'ajout d'une news avec date de début" dans le champs "Champ_Input_Description_News"
     #And l utilisateur saisit "16:02" dans le champs "Champ_Input_Heure_Debut_News"
     And l utilisateur saisit une heure supérieure à l'heure systéme
     And pause 10 secondes
     And l utilisitateur saisit la date du jour dans le champs debut date news
     And pause 15 secondes
     And l utilisateur upload "image1" dans le champs "H_Upload_photo_nouvelle_news"
     And pause 10 secondes
     And l utilisateur clique sur "Bouton_Sauvegarder_Creation_News"
     And pause 10 secondes
     And l utilisateur clique sur "Bouton_Publier_News"


    #Etape 3 : Vérification de la création de la News
     Then vérifier la création de la nouvelle news
     Then Vérifier que l actualité ne s affiche que si l heure  est égale à l heure de date de début de l'actualité






