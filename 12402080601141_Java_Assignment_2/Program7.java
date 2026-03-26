//Program:7->Implement TCP Echo Client–Server program bot

import java.io.*;
import java.net.*;

// Server class (runs in thread)
class ServerThread extends Thread {
    public void run() {
        try {
            // create server
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started...");

            // wait for client
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // input/output
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            );

            String msg;

            while ((msg = in.readLine()) != null) {
                System.out.println("Client says: " + msg);

                // echo back
                out.println("Echo: " + msg);

                if (msg.equalsIgnoreCase("exit")) break;
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Client class
class ClientThread extends Thread {
    public void run() {
        try {
            // small delay so server starts first
            Thread.sleep(1000);

            Socket socket = new Socket("localhost", 5000);

            BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
            );

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            );

            String msg;

            while (true) {
                System.out.print("Enter message: ");
                msg = userInput.readLine();

                out.println(msg);

                String response = in.readLine();
                System.out.println(response);

                if (msg.equalsIgnoreCase("exit")) break;
            }

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Main class
public class Program7 {
    public static void main(String[] args) {

        // start server thread
        ServerThread server = new ServerThread();
        server.start();

        // start client thread
        ClientThread client = new ClientThread();
        client.start();
    }
}