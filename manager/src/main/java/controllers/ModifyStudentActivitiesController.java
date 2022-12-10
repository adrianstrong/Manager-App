package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Alumno;
import models.Diario;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyStudentActivitiesController implements Initializable {

    @FXML public TextArea inputObservaciones;

    @FXML public Button btnGuardar;
    public ComboBox comboNombre;
    public ComboBox comboTipo;
    public TextField inputHorasTrabajadas;
    public TextField inputFecha;
    Session s = StudentsController.s;
    Diario diarioSeleccionado = SessionData.getDiario();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboNombre.getItems().addAll("AD", "AS", "AP","AC", "AA");
        comboTipo.getItems().addAll("FCT", "DUAL");
        inputObservaciones.setText(diarioSeleccionado.getObservaciones());
        inputHorasTrabajadas.setText(diarioSeleccionado.getHorasTrabajadas().toString());
        inputFecha.setText(diarioSeleccionado.getFecha().toString());
    }
    public void btnGuardar(){
        if(SessionData.getDiario() != null) {
            diarioSeleccionado.setTipo(comboTipo.getValue().toString());
            diarioSeleccionado.setActividad(comboNombre.getValue().toString());
            diarioSeleccionado.setHorasTrabajadas(Integer.parseInt(inputHorasTrabajadas.getText()));
            diarioSeleccionado.setFecha(inputFecha.getText());
            diarioSeleccionado.setObservaciones(inputObservaciones.getText());

            s.beginTransaction();
            s.saveOrUpdate(diarioSeleccionado);
            s.getTransaction().commit();

            btnGuardar.getScene().getWindow().hide();
        }
    }


}
