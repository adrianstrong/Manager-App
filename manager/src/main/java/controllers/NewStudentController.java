package controllers;

import csur.app.manager.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.Alumno;
import org.hibernate.Session;
import csur.app.manager.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {
    @FXML public TextField inputFechaNacimiento;
    @FXML public TextField inputEmail;
    @FXML public TextField inputTelefono;
    @FXML public TextArea inputObservaciones;
    @FXML public TextField inputNombre;
    @FXML public TextField inputApellidos;
    @FXML public TextField inputPassword;
    @FXML public TextField inputDNI;
    @FXML public Button btnGuardar;
    Session s = HibernateUtil.getSessionFactory().openSession();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void btnGuardar(){
        s.beginTransaction();
        Alumno alumno = new Alumno(
                inputNombre.getText(),
                inputApellidos.getText(),
                Utils.strMD5(inputPassword.getText()),
                inputDNI.getText(),
                inputFechaNacimiento.getText(),
                inputEmail.getText(),
                inputTelefono.getText(),
                inputObservaciones.getText()
        );

        alumno.setProfesorId(SessionData.getProfesor().getId());
        alumno.setHorasTotalesDual(200);
        alumno.setHorasTotalesFct(200);

        s.save(alumno);
        s.getTransaction().commit();
        s.close();
        btnGuardar.getScene().getWindow().hide();
    }


}
