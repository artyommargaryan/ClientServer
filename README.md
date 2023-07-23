# Pre-GraduationHell Server-Client Communication

This repository contains a simple Java implementation of a server-client communication system. The server listens for incoming client connections and responds to messages sent by the client. The server and client can exchange messages until the client sends an "exit" command to close the connection.

## Server
The `Server` class is responsible for accepting client connections and handling the communication. It listens on port 8080 for incoming connections and schedules a shutdown task if no connection is received for 2 minutes.

## Usage
To run the server, execute the `main` method in the `Server` class. The server will start and display a message indicating that it is waiting for client connections. Once a client connects, the server will display the client's IP address and initiate the message exchange.

## Dependencies
There are no external dependencies required to run the server.

## Client
The `Client` class is responsible for connecting to the server and exchanging messages with it. The client connects to the server using the IP address "127.0.0.1" and port 8080. It reads messages from the console and sends them to the server. The client also receives and displays responses from the server.

## Usage
To run the client, execute the `main` method in the `Client` class. The client will attempt to connect to the server at the specified IP address and port. You can then start exchanging messages with the server by entering text in the console. To exit the communication, simply type "exit" in the console.

## Dependencies
There are no external dependencies required to run the client.

## Communication Protocol
The server-client communication is text-based. The client sends a message string to the server, which processes the message and sends a response back to the client. The exchange continues until the client sends an "exit" command.

## Note
This is a basic demonstration of server-client communication and is not intended for production use. It does not implement error handling, security measures, or other robust features needed for real-world applications. It is recommended to use this as a starting point for learning and experimentation purposes.

Please feel free to modify and expand upon this code for your specific use cases and requirements.

