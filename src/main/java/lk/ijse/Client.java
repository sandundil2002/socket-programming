package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Socket remoteSocket = new Socket("localhost", 3002);
            DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            dataOutputStream.writeUTF("Hello server...!");

            DataInputStream dataInputStream = new DataInputStream(remoteSocket.getInputStream());
            String serverMessage = dataInputStream.readUTF();
            System.out.println("Server: " + serverMessage);

            while (true) {
                String clientMessage = input.nextLine();
                dataOutputStream.writeUTF(clientMessage);

                if (clientMessage.equals("end")) {
                    break;
                }
                String receivedMessage = dataInputStream.readUTF();
                if (receivedMessage.equals("end")) {
                    break;
                }
                System.out.println("Server: " + receivedMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
