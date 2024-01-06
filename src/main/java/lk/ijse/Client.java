package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
            String s = dataInputStream.readUTF();
            System.out.println(s);

            while (true){
                String message = input.nextLine();
                dataOutputStream.writeUTF(message);
                System.out.println(dataInputStream.readUTF());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

