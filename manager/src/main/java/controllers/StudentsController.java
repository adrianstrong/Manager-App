package controllers;

import csur.app.manager.App;
import csur.app.manager.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.Alumno;
import org.hibernate.Session;

import javax.persistence.Query;
import java.net.URL;
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
    static Session s = HibernateUtil.getSessionFactory().openSession();
    public ImageView btnGoBack;
    public ImageView btnClose;
    Query filtrado;
    Query todos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblUsuario.setText(SessionData.getProfesor().getEmail());

        filtrado = s.createQuery("from Alumno a WHERE a.profesorId= :id")
                .setParameter("id", SessionData.getProfesor().getId());
        todos = s.createQuery("from Alumno");

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));

        btnGoBack.setOnMouseClicked(event -> {
            App.newStage("Home.fxml");
            SessionData.setAlumno(null);
            SessionData.setEmpresa(null);
        });

        btnClose.setOnMouseClicked(event -> {
            System.exit(0);
        });

        updateTable();

        tableStudents.getSelectionModel().selectedItemProperty().addListener((newSelection) -> {
            if (newSelection != null) {
                fillDetails();
                SessionData.setAlumno((Alumno) tableStudents.getSelectionModel().getSelectedItem());
            }
        });

        chkAsignados.selectedProperty().addListener((newSelection) -> {
            if (chkAsignados.isSelected()) {
                tableStudents.setItems(FXCollections.observableArrayList(filtrado.getResultList()));
            } else {
                tableStudents.setItems(FXCollections.observableArrayList(todos.getResultList()));
            }
        });

    }

    public void updateTable() {
        tableStudents.getItems().clear();

        if (chkAsignados.isSelected()) {
            tableStudents.setItems(FXCollections.observableArrayList(filtrado.getResultList()));
        } else {
            tableStudents.setItems(FXCollections.observableArrayList(todos.getResultList()));
        }
    }

    public void fillDetails() {
        if (tableStudents.getSelectionModel() != null) {
            Alumno alumnoSeleccionado = (Alumno) tableStudents.getSelectionModel().getSelectedItem();

            try {
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
            } catch (NullPointerException e) {
                System.out.println(e);
            }

        }
    }

    public void btnDelete() {
        deleteAlumnoFromList();
        updateTable();
    }

    public void deleteAlumnoFromList() {
        if (tableStudents.getSelectionModel() != null) {
            Alumno alumnoSeleccionado = (Alumno) tableStudents.getSelectionModel().getSelectedItem();
            try {
                s.beginTransaction();
                s.delete(alumnoSeleccionado);
                s.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void btnActivities(ActionEvent actionEvent) {
        SessionData.setAlumno((Alumno) tableStudents.getSelectionModel().getSelectedItem());
        //fillActivities();
        App.newStage("Actividades.fxml");
    }

    public void btnCrearAlumno(ActionEvent actionEvent) {
        App.newStage("NuevoAlumno.fxml");
    }

    public void btnModificarAlumno(ActionEvent actionEvent) {
        SessionData.setAlumno((Alumno) tableStudents.getSelectionModel().getSelectedItem());
        App.newStage("ModificarAlumno.fxml");
    }

}
