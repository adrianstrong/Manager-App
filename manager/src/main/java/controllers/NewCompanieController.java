package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Empresa;
import org.hibernate.Session;

public class NewCompanieController {
    @FXML public TextArea inputObservaciones;
    @FXML public TextField inputNombre;
    @FXML public TextField inputEmail;
    @FXML public TextField inputResponsable;
    @FXML public TextField inputTelefono;
    Session s = CompaniesController.s;
    public void btnGuardar(){
        s.beginTransaction();
        Empresa empresa = new Empresa(
                inputNombre.getText(),
                inputTelefono.getText(),
                inputEmail.getText(),
                inputResponsable.getText(),
                inputObservaciones.getText()
        );
        s.save(empresa);
        s.getTransaction().commit();

        inputTelefono.getScene().getWindow().hide();
    }
}
