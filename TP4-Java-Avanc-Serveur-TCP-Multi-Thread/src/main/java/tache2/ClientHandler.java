package tache2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientHandler implements Runnable {

    private Socket socket;

    // Reçoit le Socket du client
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    // Implémente Runnable
    @Override
    public void run() {


        String threadName = Thread.currentThread().getName();
        String clientIP = socket.getInetAddress().getHostAddress();

        // Affichage du thread et IP (Tâche 3)
        System.out.println("Thread " + threadName + " traite le client " + clientIP);

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {

            String message;

            while ((message = in.readLine()) != null) {

                // Affichage du message reçu (Tâche 3)
                System.out.println("Message reçu : " + message);

                switch (message.toLowerCase()) {
                    case "hello":
                        out.println("Bonjour client !");
                        break;
                    case "time":
                        out.println("Date et heure : " + LocalDateTime.now());
                        break;
                    case "bye":
                        out.println("Connexion fermée");
                        System.out.println("Client " + clientIP + " déconnecté");
                        socket.close();
                        return;

                    default:
                        out.println("Message reçu : " + message);
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur avec le client " + clientIP + " : " + e.getMessage());
        }
    }
}