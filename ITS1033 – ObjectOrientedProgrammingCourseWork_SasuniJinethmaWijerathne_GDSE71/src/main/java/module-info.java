module com.assignment.tictactoe.service {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.gdse71.tiktaktoeoopfinalproject.controller to javafx.fxml;
    exports lk.ijse.gdse71.tiktaktoeoopfinalproject;
}