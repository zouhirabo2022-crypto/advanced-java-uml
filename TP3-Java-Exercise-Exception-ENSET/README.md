# TP3 — Gestion des Exceptions en Java

## Objectif

Maîtriser la création et la gestion d'exceptions personnalisées en Java : exceptions vérifiées (`checked`), héritage de `Exception`, blocs `try/catch/throws`, et conception de classes robustes.

---

## Structure du projet

```
TP3-Java-Exercise-Exception-ENSET/
└── src/
    ├── exercice1/
    │   ├── NombreNegatifException.java
    │   └── Main.java
    └── exercice2/
        ├── FondsInsuffisantsException.java
        └── Main.java
```

---

## Exercice 1 — Entiers Naturels

### Problématique

Créer une classe `EntierNaturel` qui garantit qu'un entier reste toujours positif ou nul, en levant une exception personnalisée dès qu'une valeur négative est détectée.

### Classes

**`NombreNegatifException`** — exception vérifiée héritant de `Exception`
- Plusieurs constructeurs (message, cause, message+cause, etc.)
- Message par défaut : `"Nombre negatif"`

**`EntierNaturel`** — encapsule un entier naturel

| Méthode | Description |
|---------|-------------|
| `EntierNaturel(int val)` | Constructeur — lève `NombreNegatifException` si `val < 0` |
| `getVal()` | Retourne la valeur courante |
| `setVal(int val)` | Modifie la valeur — lève `NombreNegatifException` si `val < 0` |
| `decrementer()` | Décrémente de 1 — lève `NombreNegatifException` si le résultat serait négatif |
| `toString()` | Retourne `"value (n)"` |

### Exemple d'exécution

```
value (5)
4
3
2
1
0
🚨 le nombre est negatif
```

---

## Exercice 2 — Compte Bancaire

### Problématique

Modéliser un système bancaire avec gestion des erreurs métier : fonds insuffisants pour un retrait ou un virement, compte inexistant pour un transfert.

### Classes

**`FondsInsuffisantsException`** — exception vérifiée héritant de `Exception`
- Constructeur avec message

**`CompteBancaire`** — classe de base

| Attribut | Type | Description |
|----------|------|-------------|
| `numeroCompte` | `int` | Identifiant du compte |
| `solde` | `double` | Solde courant |
| `nomTitulaire` | `String` | Nom du titulaire |

| Méthode | Description |
|---------|-------------|
| `depotArgent(int)` | Ajoute le montant au solde |
| `retraitArgent(int)` | Retire le montant — lève `FondsInsuffisantsException` si solde insuffisant |
| `affichageSolde()` | Retourne le solde formaté |
| `transfertArgent(CompteBancaire, int)` | Virement entre comptes — lève `FondsInsuffisantsException` si solde insuffisant ou compte `null` |

**`CompteCourant`** — hérite de `CompteBancaire`
- Attribut `decouvertAutorise` : permet un solde négatif jusqu'à la limite du découvert
- Redéfinit `retraitArgent()` pour tolérer le découvert

**`CompteEpargne`** — hérite de `CompteBancaire`
- Attribut `tauxInteret` : les dépôts génèrent des intérêts automatiquement
- Redéfinit `depotArgent()` : `solde += argent + argent * tauxInteret`

### Hiérarchie des classes

```
CompteBancaire
├── CompteCourant   (découvert autorisé)
└── CompteEpargne   (intérêts sur dépôt)
```

### Exemple d'exécution

```
5200.0               ← dépôt de 200 sur CompteCourant (solde initial 5000)
-300.0               ← retrait de 2300 sur CompteCourant (solde initial 2000, découvert 600)
le virement a été envoyer avec success
le solde est : 1700.0 DH
1704.0               ← dépôt de 200 avec taux 2% sur CompteEpargne
3412.0               ← dépôt de 400 avec taux 3% sur CompteEpargne
```

---

## Concepts abordés

- Exceptions **vérifiées** (`checked`) vs non vérifiées (`unchecked`)
- Mot-clé `throws` dans la signature des méthodes
- Blocs `try / catch`
- Création d'exceptions personnalisées par héritage de `Exception`
- Héritage et polymorphisme appliqués aux exceptions métier

---

## Technologies

- Java 17
- IntelliJ IDEA
