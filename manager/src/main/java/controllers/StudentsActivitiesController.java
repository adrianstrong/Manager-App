package controllers;

import csur.app.manager.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Alumno;
import models.Diario;
import org.hibernate.Session;
import javax.persistence.Query;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsActivitiesController implements Initializable {
    @FXML
    public TableView tableActivities;
    @FXML
    public Label lblAlumno;
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
    Alumno alumnoSeleccionado = SessionData.getAlumno();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colDate.setCellValueFactory(new PropertyValueFactory<Diario, String>("Fecha"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colWorkedHours.setCellValueFactory(new PropertyValueFactory<>("HorasTrabajadas"));
        colActivities.setCellValueFactory(new PropertyValueFactory<>("Actividad"));
        colObservations.setCellValueFactory(new PropertyValueFactory<>("Observaciones"));

        fillActivities();
    }

    public void updateTable(){
        tableActivities.getItems().clear();
    }

    public void fillActivities() {
        updateTable();
        Query actividades = s.createQuery("from Diario d WHERE d.alumnoId = :id")
               .setParameter("id", alumnoSeleccionado.getId());
        tableActivities.setItems(FXCollections.observableArrayList(actividades.getResultList()));
    }

}
