package johnny.java.app.socket;

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        String serverName = "localhost";
        int port = 8722; // Same port number with the server
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        System.out.println("UPD Client launched, using server: " + serverName + ", Port: " + port);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(serverName);
        String userInput = "";
        do {
            userInput = "";
            System.out.print("Enter any string now, (quit) to end: ");
            System.out.flush();
            userInput = inFromUser.readLine();
            if (userInput.equalsIgnoreCase("quit")) {
                break;
            }
            sendData = userInput.getBytes();

            // Define upd package and send to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
            System.out.println("[UDPClient] Send out user input [" + userInput + "] to Server.");
            //
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            // get actual date with proper length
            byte[] actualData = new byte[receivePacket.getLength()];
            System.arraycopy(receivePacket.getData(), receivePacket.getOffset(), actualData, 0, receivePacket.getLength());
            String responseFromServer = new String(actualData);
            System.out.println("[UDPClient] Get response [" + responseFromServer + "] from Server.");
        } while (!userInput.equals("quit")); // End the client if 'quit' is an input

        // Close connection
        if (clientSocket != null) {
            clientSocket.close();
        }
    }
}
