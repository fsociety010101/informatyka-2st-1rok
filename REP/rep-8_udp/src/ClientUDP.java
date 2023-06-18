import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ClientUDP {
    // to store text from client
    private static List<String> clientText = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(8187);
            InetAddress ia = InetAddress.getByName("localhost");

            // get username
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = bufferedReader.readLine();
            byte[] buffer = userInput.getBytes();

            // send username
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, ia, 8188);
            clientSocket.send(sendPacket);
            System.out.println("Client has sent: " + userInput);

            // receive welcome message
            buffer = new byte[100];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivePacket);
            String serverInput = new String(buffer);
            System.out.println("Client has received: " + serverInput.trim());

            // get 3 lines of text from user
            for (int i = 0; i < 3; i++) {
                userInput = bufferedReader.readLine();
                clientText.add(userInput);
            }

            // send 3 lines of text
            for (String text : clientText) {
                buffer = text.getBytes();
                sendPacket = new DatagramPacket(buffer, buffer.length, ia, 8188);
                clientSocket.send(sendPacket);
                System.out.println("Client has sent: " + text);
            }

            // receive concatenated text
            buffer = new byte[100];
            receivePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivePacket);
            serverInput = new String(buffer);
            System.out.println("Client has received: " + serverInput.trim());

            // receive end flag
            buffer = new byte[100];
            receivePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(receivePacket);
            serverInput = new String(buffer);
            System.out.println("Client has received: " + serverInput.trim());

            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}