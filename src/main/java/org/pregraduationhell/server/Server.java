package org.pregraduationhell.server;

import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server running. Waiting for connections...");

            Timer timer = new Timer();
            timer.schedule(new ServerShutdownTask(serverSocket), 120000); // 2 minutes = 120,000 milliseconds


            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client: " + message);
                    if (message.contains("exit")) {
                        System.out.println("Exit command received. Closing server...");
                        break;
                    }

                    System.out.print("Enter response: ");
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    String response = consoleReader.readLine();
                    writer.println(response);
                    System.out.println("Response sent");
                }

                socket.close();

                timer = new Timer();
                timer.schedule(new ServerShutdownTask(serverSocket), 120000); // Reschedule the timer
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerShutdownTask extends TimerTask {
        private ServerSocket serverSocket;

        public ServerShutdownTask(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            System.out.println("No connection for 2 minutes. Closing server...");
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0); // This will forcefully terminate the server
        }
    }
}

