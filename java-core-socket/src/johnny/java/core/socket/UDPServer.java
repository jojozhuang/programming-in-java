package johnny.java.core.socket;

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        int port = 8722; // Same port number with the server
        Socket socket = null;
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("UDP Server is starting up, waiting for request...");
        while(true) {
            receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            // get actual date with proper length
            byte[] actualData = new byte[receivePacket.getLength()];
            System.arraycopy(receivePacket.getData(), receivePacket.getOffset(), actualData, 0, receivePacket.getLength());
            String clientInput = new String(actualData);
            System.out.println("[UPDServer] Received input [" + clientInput + "] from Client.");
            // Find the ip address and port of sender
            InetAddress IPAddress = receivePacket.getAddress();
            port = receivePacket.getPort();

            String responseToClient = clientInput.toUpperCase();
            sendData = responseToClient.getBytes();
            // Define upd package
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            // Send
            serverSocket.send(sendPacket);
            System.out.println("[UPDServer] Send out response [" + responseToClient + "] to Client.");
        }
    }
}
