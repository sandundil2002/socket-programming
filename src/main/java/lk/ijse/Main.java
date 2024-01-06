package lk.ijse;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            System.out.println("Server is started");
            serverSocket.accept();
            System.out.println("Server is accept");
            Socket localSocket = new Socket();
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
            String message = dataInputStream.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}