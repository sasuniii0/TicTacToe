package lk.ijse.gdse71.tiktaktoeoopfinalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/MainLayoutView.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> {
            event.consume(); // let the whole event finish (this wont allow the window to close if we press buttons other than "ok")
            closeScene(stage); // pass the current stage
        });

        stage.setResizable(false);
        stage.setTitle("Tik-Tak-Toe");
        stage.show();
    }

    private void closeScene(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure... you want to exit?", ButtonType.YES, ButtonType.NO);
        if(alert.showAndWait().get() == ButtonType.YES) {
            stage.close();

        }
    }
}
