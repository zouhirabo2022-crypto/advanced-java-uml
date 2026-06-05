# Java Avancé — ENSET

Dépôt regroupant les travaux pratiques du module **Java Avancé** réalisés à l'ENSET. Chaque TP explore un concept fondamental de la programmation Java orientée objet et réseau.

---

## Table des matières

- [TP1 — Programmation Orientée Objet Avancée](#tp1--programmation-orientée-objet-avancée)
- [TP2 — Généricité](#tp2--généricité)
- [TP3 — Gestion des Exceptions](#tp3--gestion-des-exceptions)
- [TP4 — Serveur TCP Multi-Thread](#tp4--serveur-tcp-multi-thread)
- [Prérequis](#prérequis)
- [Structure du dépôt](#structure-du-dépôt)

---

## TP1 — Programmation Orientée Objet Avancée

**Répertoire :** `TP1-Java-Exercise-Advanced-OOP-ENSET/`

Six exercices couvrant les piliers de la POO : héritage, classes abstraites, interfaces et polymorphisme.

| Exercice | Thème | Classes principales |
|----------|-------|---------------------|
| Exercise 1 | Gestion d'une bibliothèque | `Personne`, `Adherent`, `Auteur`, `Livre` |
| Exercise 2 | Hiérarchie de véhicules | `Vehicule` et sous-classes |
| Exercise 3 | Gestion des salaires | `Employe` (abstraite), `Ingenieur`, `Manager` |
| Exercise 4 | Figures géométriques | `Figure` (abstraite), `Cercle`, `Rectangle`, `Triangle` |
| Exercise 5 | Système d'emprunt | Interface `Empruntable`, `Livre`, `DVD` |
| Exercise 6 | Système de paiement | `Paiement` (abstraite), `CarteCredit`, `PayPal` |

**Concepts abordés :** héritage, surcharge de `toString()`, classes abstraites, interfaces, polymorphisme.

---

## TP2 — Généricité

**Répertoire :** `TP2-Java-Exercise-Generics-ENSET/`

Implémentation d'une application de gestion de produits en utilisant la généricité Java.

- Interface générique `IMetier<T>` avec les méthodes `add`, `getAll`, `findById`, `delete`
- Classe `MetierProduitImpl` implémentant `IMetier<Produit>`
- Application console interactive avec menu CRUD complet

**Concepts abordés :** types génériques (`<T>`), interfaces génériques, collections (`ArrayList`, `List`).

---

## TP3 — Gestion des Exceptions

**Répertoire :** `TP3-Java-Exercise-Exception-ENSET/`

Deux exercices sur la création et la gestion d'exceptions personnalisées.

**Exercice 1 — Entiers naturels**
- Classe `EntierNaturel` pour gérer des entiers positifs ou nuls
- Exception personnalisée `NombreNegatifException` levée lors d'une valeur négative
- Méthodes `setVal()`, `decrementer()` avec gestion des exceptions

**Exercice 2 — Compte bancaire**
- Classe `CompteBancaire` avec opérations de dépôt, retrait et virement
- Exception personnalisée `FondsInsuffisantsException`
- `CompteCourant` (avec découvert autorisé) et `CompteEpargne` (avec taux d'intérêt)

**Concepts abordés :** exceptions vérifiées (`checked`), exceptions personnalisées, `try/catch`, héritage d'exceptions.

---

## TP4 — Serveur TCP Multi-Thread

**Répertoire :** `TP4-Java-Avanc-Serveur-TCP-Multi-Thread/`

Développement d'un serveur TCP capable de gérer plusieurs clients simultanément grâce à un pool de threads.

**Fonctionnalités :**
- Écoute sur le port **5000**
- Gestion concurrente des clients via `ExecutorService`
- Commandes supportées :
  - `hello` → `Bonjour client !`
  - `time` → affiche la date et l'heure courantes
  - `bye` → ferme la connexion du client
  - tout autre message → `Message reçu : [message]`
- Journalisation de l'adresse IP et du thread traitant chaque client

**Lancer le serveur :**
```bash
# Compiler et exécuter MultiThreadServer.java
# Puis se connecter via Telnet :
telnet localhost 5000
```

**Concepts abordés :** sockets TCP (`ServerSocket`, `Socket`), `ExecutorService`, multi-threading, `BufferedReader`, `PrintWriter`.

---

## Prérequis

- **Java 17** ou supérieur
- **Maven** (pour TP1 et TP4)
- **Telnet** (pour tester le TP4)
- IDE recommandé : IntelliJ IDEA

---

## Structure du dépôt

```
Java Avancer/
├── TP1-Java-Exercise-Advanced-OOP-ENSET/
│   └── src/main/java/
│       ├── Exercise1/Main.java   # Bibliothèque
│       ├── Exercise2/Main.java   # Véhicules
│       ├── Exercise3/Main.java   # Salaires
│       ├── Exercise4/Main.java   # Figures géométriques
│       ├── Exercise5/Main.java   # Emprunt
│       └── Exercise6/Main.java   # Paiement
├── TP2-Java-Exercise-Generics-ENSET/
│   └── src/Main.java             # Gestion de produits (CRUD générique)
├── TP3-Java-Exercise-Exception-ENSET/
│   └── src/
│       ├── exercice1/            # EntierNaturel + NombreNegatifException
│       └── exercice2/            # CompteBancaire + FondsInsuffisantsException
└── TP4-Java-Avanc-Serveur-TCP-Multi-Thread/
    └── src/main/java/
        ├── tache1/MultiThreadServer.java
        └── tache2/ClientHandler.java
```

---

**Auteur :** Khalid Aimed — ENSET
