package lk.ijse.gdse71.tiktaktoeoopfinalproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLayoutController {

    @FXML
    private Button BtnContinue;

    @FXML
    private ImageView ImgMain;

    @FXML
    private Text LblDesc;

    @FXML
    private AnchorPane MainAncPane;



    @FXML
    void BtnContinueOnAction(ActionEvent event) throws IOException {
        navigateTo("/view/BoardView.fxml");
    }

    public void navigateTo(String fxmlPath) {
        try{
            MainAncPane.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.prefWidthProperty().bind(MainAncPane.widthProperty());
            load.prefHeightProperty().bind(MainAncPane.heightProperty());
            MainAncPane.getChildren().add(load);
        }catch (IOException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load page").show();
        }
    }
}
