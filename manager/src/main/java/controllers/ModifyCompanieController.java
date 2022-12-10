package controllers;

import csur.app.manager.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Alumno;
import models.Empresa;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyCompanieController implements Initializable {

    public TextArea inputObservaciones;
    public TextField inputNombre;
    public TextField inputEmail;
    public TextField inputResponsable;
    public TextField inputTelefono;
    Session s = CompaniesController.s;
    Empresa empresaSeleccionada = SessionData.getEmpresa();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputNombre.setText(empresaSeleccionada.getNombre());
        inputEmail.setText(empresaSeleccionada.getEmail());
        inputTelefono.setText(empresaSeleccionada.getTelefono().toString());
        inputResponsable.setText(empresaSeleccionada.getResponsable());
        inputObservaciones.setText(empresaSeleccionada.getObservaciones());

    }
    public void btnGuardar(){
        empresaSeleccionada.setNombre(inputNombre.getText());
        empresaSeleccionada.setEmail(inputEmail.getText());
        empresaSeleccionada.setTelefono(inputTelefono.getText());
        empresaSeleccionada.setResponsable(inputResponsable.getText());
        empresaSeleccionada.setObservaciones(inputObservaciones.getText());
        s.beginTransaction();
        s.saveOrUpdate(empresaSeleccionada);
        s.getTransaction().commit();

        inputNombre.getScene().getWindow().hide();
    }


}
