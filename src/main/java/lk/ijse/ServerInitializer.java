package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerInitializer.class.getResource("/view/server_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Server Form");
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoaders = new FXMLLoader(ServerInitializer.class.getResource("/view/client_form.fxml"));
        Scene scenes = new Scene(fxmlLoaders.load());
        Stage client = new Stage();
        client.setTitle("Client Form");
        client.setScene(scenes);
        client.show();
    }

    public static void main(String[] args) {
        launch();
    }
}