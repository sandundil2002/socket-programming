package lk.ijse;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket remoteSocket = new Socket("localhost", 3002);
            DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            System.out.println("Hello server...!");
            dataOutputStream.writeUTF("Hello server...!");
            dataOutputStream.flush();
            dataOutputStream.close();
            remoteSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

