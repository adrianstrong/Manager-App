package controllers;

import csur.app.manager.App;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    public Button btnStudents;
    public Button btnEmpresas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnStudents.setOnAction(event -> {
            App.newStage("Estudiantes.fxml");
            btnStudents.getScene().getWindow().hide();
        });

        btnEmpresas.setOnAction(event -> {
            App.newStage("Empresas.fxml");
            btnEmpresas.getScene().getWindow().hide();
        });

    }
}
