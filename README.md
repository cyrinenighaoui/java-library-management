# 📚 Java Library Management System

> Application de gestion d'une bibliothèque développée en Java avec Swing, intégrant un système de recommandation de livres.

---

## 🚀 Présentation

Ce projet a été réalisé dans le cadre d’un module universitaire. Il s’agit d’un **système complet de gestion de bibliothèque**, permettant la gestion des abonnés, des employés, des ouvrages, des emprunts, des réservations, des livraisons et plus encore.

L’application inclut une **interface graphique ** (Swing) et un **système intelligent de recommandation de livres** basé sur les historiques d’emprunts.

---

## 🛠️ Technologies utilisées

- **Langage :** Java
- **Interface graphique :** Swing
- **Connexion BD :** JDBC
- **Base de données :** MySQL
- **IDE utilisé :** NetBeans
- **Recommandation :** Algorithme de **filtrage collaboratif** (basé sur les emprunts passés des utilisateurs)

---

## 📁 Structure du projet

```plaintext
java-library-management/
│
├── src/
│   ├── biblio/                # Entités métier : Livre, Abonné, Emprunt, etc.
│   ├── com/raven/             # Interfaces graphiques, formulaires, services
│   ├── Livraison/             # Modules liés à la gestion des livraisons
│
├── imagesabonnes/            # Ressources images pour les abonnés
├── imagesemployes/           # Ressources images pour les employés
└── README.md                 # Ce fichier
```
## 📥 Clonage du projet


```bash
git clone https://github.com/TON-USERNAME/java-library-management.git
cd java-library-management
```
## ▶️ Exécution du projet (NetBeans)
### Prérequis

- Java JDK 8 ou +

- NetBeans IDE

- MySQL Server

###Étapes

1- Ouvrir NetBeans

2- File → Open Project

3- Sélectionner le dossier java-library-management

4- NetBeans reconnaît automatiquement le projet

5- Cliquer sur Run ▶️

## 🗄️ Configuration de la base de données


```bash
## 🗄️ Base de données

- Créer une base de données MySQL (ex: `library_db`)
- Importer le script SQL (si disponible)
- Modifier les paramètres de connexion dans le fichier JDBC :

```java
String url = "jdbc:mysql://localhost:3306/library_db";
String user = "root";
String password = "";

```











