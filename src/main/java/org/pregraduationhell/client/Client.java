package org.pregraduationhell.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, PORT);
            System.out.println("Connected to server: " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String message;
            do {
                System.out.print("Enter message (or 'exit' to quit): ");
                message = consoleReader.readLine();
                writer.println(message);
                System.out.println("Message sent");

                String response = reader.readLine();
                System.out.println("Server: " + response);
            } while (!message.contains("exit"));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
