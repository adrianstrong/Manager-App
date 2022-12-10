package controllers;

import csur.app.manager.App;
import csur.app.manager.HibernateUtil;
import csur.app.manager.Utils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

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
        Session s = HibernateUtil.getSessionFactory().openSession();

        if(Utils.checkCredentials(usuario.getText(), contrasenha.getText())) {
            usuario.getScene().getWindow().hide();
            login();
        }
        usuario.setText("");
        contrasenha.setText("");
    }
    public void login() {
        if (SessionData.getContextoAdmin()) {
            App.newStage("Home.fxml");
        }
        else {
            App.newStage("StudentView.fxml");

        }
    }
}
