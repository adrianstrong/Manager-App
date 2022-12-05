package controllers;

import csur.app.manager.App;
import csur.app.manager.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Alumno;
import models.Diario;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.persistence.Query;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colLastName;
    @FXML
    public TableView tableStudents;
    @FXML
    public Label lblNombreAlumno;
    @FXML
    public Label lblDniAlumno;
    @FXML
    public Label lblNacimientoAlumno;
    @FXML
    public Label lblCorreoAlumno;
    @FXML
    public Label lblTelefonoAlumno;
    @FXML
    public Label lblNombreEmpresa;
    @FXML
    public Label lblNombreResponsableEmpresa;
    @FXML
    public Label lblCorreoEmpresa;
    @FXML
    public Label lblTelefonoEmpresa;
    @FXML
    public Label lblHorasTotalDual;
    @FXML
    public Label lblHorasRealizadasDual;
    @FXML
    public Label lblHorasTotalFct;
    @FXML
    public Label lblHorasRealizadasFct;
    @FXML
    public CheckBox chkAsignados;
    @FXML
    public Label lblUsuario;
    @FXML
    public TableView tableActivities;
    @FXML
    public Label lblAlumno;
    @FXML
    public TableColumn colDate;
    @FXML
    public TableColumn colTipo;
    @FXML
    public TableColumn colWorkedHours;
    @FXML
    public TableColumn colActivities;
    @FXML
    public TableColumn colObservations;
    Session s = HibernateUtil.getSessionFactory().openSession();
    Query filtrado;
    Query todos;

    ObservableList actividadesAlumno = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblUsuario.setText(SessionData.getProfesor().getEmail());

        filtrado = s.createQuery("from Alumno a WHERE a.profesorId= :id")
                .setParameter("id", SessionData.getProfesor().getId());

        todos = s.createQuery("from Alumno");

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));



        updateTable();

        tableStudents.getSelectionModel().selectedItemProperty().addListener((newSelection) -> {
            if (newSelection != null) {
                fillDetails();
                SessionData.setAlumno((Alumno) tableStudents.getSelectionModel().getSelectedItem());
            }
        });

        chkAsignados.selectedProperty().addListener((newSelection) -> {
            if(chkAsignados.isSelected()) {
                tableStudents.setItems(FXCollections.observableArrayList(filtrado.getResultList()));
            } else {
                tableStudents.setItems(FXCollections.observableArrayList(todos.getResultList()));
            }
        });

    }

    public void updateTable(){
        tableStudents.getItems().clear();

        tableStudents.getItems().addAll(filtrado.getResultList());

    }

    public void fillDetails() {
            if (tableStudents.getSelectionModel() != null) {
            Alumno alumnoSeleccionado = (Alumno) tableStudents.getSelectionModel().getSelectedItem();

            lblNombreAlumno.setText(alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellidos());
            lblDniAlumno.setText(alumnoSeleccionado.getDni());
            lblNacimientoAlumno.setText(alumnoSeleccionado.getFechaNacimiento().toString());
            lblCorreoAlumno.setText(alumnoSeleccionado.getEmail());
            lblTelefonoAlumno.setText(alumnoSeleccionado.getTelefono().toString());

            lblNombreEmpresa.setText(alumnoSeleccionado.getEmpresaByEmpresaId().getNombre());
            lblNombreResponsableEmpresa.setText(alumnoSeleccionado.getEmpresaByEmpresaId().getResponsable());
            lblCorreoEmpresa.setText(alumnoSeleccionado.getEmpresaByEmpresaId().getEmail());
            lblTelefonoEmpresa.setText(alumnoSeleccionado.getEmpresaByEmpresaId().getTelefono().toString());

            lblHorasTotalDual.setText(alumnoSeleccionado.getHorasTotalesDual().toString());
            lblHorasRealizadasDual.setText(alumnoSeleccionado.getHorasTotalesFct().toString());
            lblHorasTotalFct.setText(alumnoSeleccionado.getHorasTotalesFct().toString());
            lblHorasRealizadasFct.setText(alumnoSeleccionado.getHorasTotalesFct().toString());
        }
    }

    public void fillActivities(){
        if (tableStudents.getSelectionModel() != null) {
            Alumno alumnoSeleccionado = (Alumno) tableStudents.getSelectionModel().getSelectedItem();

            colDate.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
            colWorkedHours.setCellValueFactory(new PropertyValueFactory<>("HorasTrabajadas"));
            colActivities.setCellValueFactory(new PropertyValueFactory<>("Actividad"));
            colObservations.setCellValueFactory(new PropertyValueFactory<>("Observaciones"));

            Query actividades = s.createQuery("from Diario d WHERE d.alumnoId = :id")
                    .setParameter("id", alumnoSeleccionado.getId());

            actividadesAlumno.add(actividades.getResultList());

            tableActivities.getItems().addAll(actividadesAlumno);
        }
    }

    public void btnActivities(ActionEvent actionEvent) {
        fillActivities();
        App.newStage("Actividades.fxml");
    }


}
