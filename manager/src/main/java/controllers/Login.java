package controllers;

import csur.app.manager.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    public TextField usuario;
    @FXML
    public TextField contrasenha;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void btnClose() {
        System.exit(0);
    }

    @FXML
    public void loginButton() {
        usuario.getScene().getWindow().hide();
        login();
    }
    public void login() {
        App.newStage("Home.fxml");
    }
}
