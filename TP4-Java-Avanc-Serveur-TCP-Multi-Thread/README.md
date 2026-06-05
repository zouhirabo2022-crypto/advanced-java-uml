# TP4 : Serveur TCP Multi-Thread

## Objectif
Développer un serveur TCP capable de :
- Gérer plusieurs clients simultanément
- Utiliser un pool de threads (ExecutorService)
- Répondre dynamiquement aux messages envoyés via Telnet

## Fonctionnalités
- Connexion multiple de clients sur le port 5000
- Traitement de chaque client dans un thread du pool
- Réponses aux messages :
  - `hello` → `Bonjour client !`
  - `time` → affiche la date et l’heure actuelles
  - `bye` → ferme la connexion de ce client
  - autres messages → renvoie `Message reçu : [message]`
- Journalisation :
  - IP du client
  - Nom du thread traitant le client
  - Messages reçus

## Tests
1. Lancer le serveur via `MultiThreadServer.java`
2. Ouvrir plusieurs fenêtres Telnet : `telnet localhost 5000`
3. Envoyer différents messages et vérifier les réponses
4. Vérifier que le serveur continue de fonctionner après la déconnexion d’un client

## Structure du projet

TCPServerTP/
│
├─ src/main/java/tache1/MultiThreadServer.java
├─ src/main/java/tache2/ClientHandler.java
└─ README.md


## Technologies
- Java 17
- ExecutorService pour la gestion des threads
- Telnet pour tester les connexions clients

## Capture
![alt text](/images/1.png)
![alt text](/images/2.png)
![alt text](/images/3.png)
![alt text](/images/4.png)
![alt text](/images/5.png)
![alt text](/images/6.png)