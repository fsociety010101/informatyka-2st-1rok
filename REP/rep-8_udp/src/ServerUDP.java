import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;

public class ServerUDP extends Thread {
    public static final int BUFFER = 1024;
    public static final int PORT = 8188;
    DatagramSocket serverSocket;
    byte[] buff = new byte[BUFFER];
    private Map<Integer, ClientObject> clients = new HashMap<Integer, ClientObject>();

    public ServerUDP() {
        try {
            serverSocket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        while (true) {
            try {
                Arrays.fill(buff, (byte) 0);

                // receive username
                DatagramPacket receivePacket = new DatagramPacket(buff, buff.length);
                serverSocket.receive(receivePacket);
                String clientInput = new String(buff).trim();
                System.out.println("Server has received: " + clientInput);

                // receive user's ip and port and write to new object
                int port = receivePacket.getPort();
                InetAddress ia = receivePacket.getAddress();
                // if user is new create new object
                if (clients.get(port) == null) {
                    ClientObject newUser = new ClientObject(port, ia, clientInput, 0);
                    clients.put(port, newUser);
                }

                // get current user
                ClientObject currentUser = clients.get(port);

                // send welcome message
                String serverInput = "Welcome " + currentUser.getUsername();
                buff = serverInput.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(buff, buff.length, ia, port);
                serverSocket.send(sendPacket);
                System.out.println("Server has sent: " + serverInput.trim());
                Arrays.fill(buff, (byte) 0);

                while (currentUser.getCount() < 3) {
                    // update counter
                    currentUser.incCount();

                    // receive lines of text
                    buff = new byte[BUFFER];
                    receivePacket = new DatagramPacket(buff, buff.length);
                    serverSocket.receive(receivePacket);
                    clientInput = new String(buff);

                    currentUser = clients.get(receivePacket.getPort());

                    // handle text
                    System.out.println("Server has received: " + clientInput.trim());
                    currentUser.setText(clientInput.trim());
                }
                // send concatenated text
                buff = currentUser.getText().getBytes();
                sendPacket = new DatagramPacket(buff, buff.length, ia, port);
                serverSocket.send(sendPacket);
                System.out.println("Server has sent: " + currentUser.getText());

                // send end flag
                serverInput = "End";
                buff = serverInput.getBytes();
                sendPacket = new DatagramPacket(buff, buff.length, ia, port);
                serverSocket.send(sendPacket);
                System.out.println("Server has sent: " + serverInput.trim());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ServerUDP serverUDP = new ServerUDP();
        System.out.println("Server is active...");
        serverUDP.start();
    }
}
