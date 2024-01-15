package lk.ijse.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientFormController {
    public TextField txtMsg;
    public JFXTextArea txtField;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String message = "";

    public void initialize(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost",3002);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!message.equals("end")){
                    message = dataInputStream.readUTF();
                    txtField.appendText("\nServer: "+message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
            dataOutputStream.writeUTF(txtMsg.getText().trim());
            dataOutputStream.flush();
            txtMsg.setText("");
    }
}
