package lk.ijse.gdse71.tiktaktoeoopfinalproject.controller;

/*import com.assignment.tictactoe.service.state.*;*/
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.gdse71.tiktaktoeoopfinalproject.state.*;

import java.io.IOException;

public class BoardViewController implements BoardUi {

    @FXML
    private Button Btn00;

    @FXML
    private Button Btn01;

    @FXML
    private Button Btn02;

    @FXML
    private Button Btn10;

    @FXML
    private Button Btn11;

    @FXML
    private Button Btn12;

    @FXML
    private Button Btn20;

    @FXML
    private Button Btn21;

    @FXML
    private Button Btn22;

    @FXML
    private Button BtnExit;

    @FXML
    private Button BtnRestart;

    @FXML
    private ImageView ImgInfo;

    @FXML
    private GridPane MainGrid;

    // internel state eka manage krnwa
    BoardImpl board;
    AiPlayer aiPlayer;
    HumanPlayer humanPlayer;

    //
    public BoardViewController() {
        board = new BoardImpl();
        aiPlayer = new AiPlayer(board);
        humanPlayer = new HumanPlayer(board);
    }

    @FXML
    void BtnExitOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?", ButtonType.NO, ButtonType.YES);
        if (ButtonType.YES == alert.showAndWait().get()) {
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    void InfoOnAction(MouseEvent event) throws IOException {
        FXMLLoader sendMailView = new FXMLLoader(getClass().getResource("/view/info.fxml"));
        Parent load = sendMailView.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.initModality(Modality.APPLICATION_MODAL);// window ekak uda thwa window ekak inne pahala window eka disable krla tiyagnna puluwn me stage scene eken
        stage.initOwner(ImgInfo.getScene().getWindow());
        stage.show();
    }


    @FXML
    void LblGridPaneOnAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
        int id = Integer.parseInt(btn.getId().substring(1))-1;

        int row = id/3;
        int col = id%3;

        if (btn.getText().isEmpty()){
            humanPlayer.move(row, col);
            aiPlayer.findBestMove();
            board.printBoard();
            updateUi();
        }
        if (board.checkWinner() != null){
            notifyWinner(board.checkWinner().getWinningPiece());
        } else if (board.isBoardFull()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Game Tied...", ButtonType.OK);
            alert.show();
            board.initializeBoard();
            updateUi();

        }
    }
    private void updateUi() {
        for (int i = 0; i < board.getPieces().length; i++) {
            for (int j = 0 ; j< board.getPieces()[i].length; j++) {
                update(i,j,board.getPieces()[i][j]);
            }
        }
    }

    @Override
    public void update(int row, int col, Piece piece) {
        String btn = "B" +( row*3 + col+1);
        for (Node node : MainGrid.getChildren()) {
            if (node instanceof Button button && btn.equals(node.getId())) {
                if(piece == Piece.X){
                    button.setText("X");
                } else if (piece == Piece.O) {
                    button.setText("O");
                }else {
                    button.setText("");
                }
                break;
            }
        }
    }

    @Override
    public void notifyWinner(Piece winner) {
        if (winner == Piece.X) {
          new Alert(Alert.AlertType.INFORMATION,"Winner X").showAndWait();
            board.initializeBoard();
            updateUi();
        }else if (winner == Piece.O) {
            new Alert(Alert.AlertType.INFORMATION,"Winner O").showAndWait();
            board.initializeBoard();
            updateUi();
        }
    }
}
