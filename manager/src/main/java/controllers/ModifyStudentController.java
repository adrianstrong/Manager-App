package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Alumno;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyStudentController implements Initializable {
    @FXML public TextField inputFechaNacimiento;
    @FXML public TextField inputEmail;
    @FXML public TextField inputTelefono;
    @FXML public TextArea inputObservaciones;
    @FXML public TextField inputNombre;
    @FXML public TextField inputApellidos;
    @FXML public TextField inputDNI;
    @FXML public Button btnGuardar;
    Session s = StudentsController.s;
    Alumno alumnoSeleccionado = SessionData.getAlumno();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputNombre.setText(alumnoSeleccionado.getNombre());
        inputApellidos.setText(alumnoSeleccionado.getApellidos());
        inputDNI.setText(alumnoSeleccionado.getDni());
        inputFechaNacimiento.setText(alumnoSeleccionado.getFechaNacimiento());
        inputEmail.setText(alumnoSeleccionado.getEmail());
        inputTelefono.setText(alumnoSeleccionado.getTelefono());
        inputObservaciones.setText(alumnoSeleccionado.getObservaciones());

    }
    public void btnGuardar(){
        if(SessionData.getAlumno() != null) {
            Alumno alumno = SessionData.getAlumno();
            alumno.setNombre(inputNombre.getText());
            alumno.setApellidos(inputApellidos.getText());
            alumno.setDni(inputDNI.getText());
            alumno.setFechaNacimiento(inputFechaNacimiento.getText());
            alumno.setEmail(inputEmail.getText());
            alumno.setTelefono(inputTelefono.getText());
            alumno.setObservaciones(inputObservaciones.getText());

            alumno.setProfesorId(SessionData.getProfesor().getId());
            alumno.setHorasTotalesDual(200);
            alumno.setHorasTotalesFct(200);
            s.beginTransaction();
            s.saveOrUpdate(alumno);
            s.getTransaction().commit();

            btnGuardar.getScene().getWindow().hide();
        }
    }


}
