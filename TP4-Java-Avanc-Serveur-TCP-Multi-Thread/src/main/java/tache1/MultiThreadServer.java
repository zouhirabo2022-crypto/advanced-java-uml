package tache1;

import tache2.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    public static void main(String[] args) {
        int port = 5000;
        // Q2 : Création du pool de threads (5 max)
        ExecutorService executorService = Executors.newFixedThreadPool(5);


            // Q1 : Ouverture ServerSocket
            try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Serveur démarré sur le port " + port);

            // Q3 : Boucle infinie
            while (true) {

                // Attente connexion client
                Socket clientSocket = serverSocket.accept();


                // Q4 : Affichage IP client + (Tâche 3)
                String clientIP = clientSocket.getInetAddress().getHostAddress();
                System.out.println("Client connecté : " + clientIP);

                // Q4 : Envoi au pool de threads
                executorService.execute(new ClientHandler(clientSocket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

}