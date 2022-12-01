package controllers;

import csur.app.manager.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Alumno;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colLastName;
    @FXML
    public TableView tableStudents;
    Session s = HibernateUtil.getSessionFactory().openSession();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableStudents.getItems().clear();

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));

        ObservableList<Alumno> datos = FXCollections.observableArrayList();
        tableStudents.getItems().addAll(s.createQuery("FROM Alumno").list());


    }


}
