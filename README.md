# Library Project (Scala)

## Travail demandé
Ce projet consiste à réaliser une application en **Scala** permettant de gérer les documents d’une bibliothèque (livres, magazines, bandes dessinées), avec la possibilité d’enregistrer des utilisateurs et de gérer les emprunts/retours.

---

## Outils utilisés
- Scala : Programmation orienté object (classes, héritage, abstraction, traits)
- VS Code : éditeur de code
- Metals : extension VS Code pour créer et gérer des projets Scala avec toutes les dépendances
- sbt : outil de build et gestion des dépendances
- Typesafe Config : gestion des fichiers de configuration (application.conf)
- AWS RDS : Gestionnaire de base de données relationnelle
- PosgreSQL : Base de données relationnelle
- Slick : ORM (Object-Relational-Mapping) pour Scala

---

## Structure du projet

<pre>TP-Scala/
│
│── src/
│ └── main/scala/
│              └── database # Connexion à AWS RDS
│                  └── DatabaseManager.scala
│                  └── DatabaseModels.scala
│                  └── DatabaseTable.scala
│                  └── Mappers.scala
│              └── models # Classes
│                 └── Bokk.scala
│                 └── Comic.scala
│                 └── User.scala
│                 └── Document.scala
│                 └── Magazine.scala
│                 └── Borrowable.scala
│                 └── Librairy.scala
│              └── Main.scala # Code principal
│     └── ressources
│         └── application.config # Fichier de configuration d'environnement
│
│── build.sbt # Fichier de configuration SBT
│── README.md # Documentation du projet
│── gitignore # Fichiers et dossiers à ignorer
 </pre>

---

## Exécution du projet

1. Cloner le projet :

   `git clone https://github.com/youcefnamoun01/scala-tp2.git`

2- Ajouter les variables de configurations AWS dans le fichier main/resources/application.config

![RDS-AWS](https://kuikopsimages.s3.eu-north-1.amazonaws.com/rds-config.png)

3- Executer la commande

`sbt run`