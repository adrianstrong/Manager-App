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
import javafx.scene.image.ImageView;
import models.Alumno;
import models.Diario;
import org.hibernate.Session;

import javax.persistence.Query;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    public TableColumn colActividad;
    public TableColumn colTipoActividad;
    public TableColumn colHorasTrabajadas;
    public TableColumn colComentarios;
    @FXML
    public TableView tableActivities;
    @FXML
    public Label lblUsuario;
    public Button btnAddActvidad;
    public Button btnBorrarActividad;
    public ComboBox comboActividades;
    public ComboBox comboTipo;
    public TextField inputHorasTrabajas;
    public TextField inputFecha;
    public TextArea inputObs;
    public ImageView btnGoBack;
    public ImageView btnClose;

    Session s = HibernateUtil.getSessionFactory().openSession();
    Query filtrado;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblUsuario.setText(SessionData.getAlumno().getEmail());

        filtrado = s.createQuery("from Diario d WHERE d.alumnoId= :id")
                .setParameter("id", SessionData.getAlumno().getId());

        colActividad.setCellValueFactory(new PropertyValueFactory<>("Actividad"));
        colTipoActividad.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colHorasTrabajadas.setCellValueFactory(new PropertyValueFactory<>("HorasTrabajadas"));
        colComentarios.setCellValueFactory(new PropertyValueFactory<>("Observaciones"));

        comboTipo.getItems().addAll("FCT", "DUAL");
        comboActividades.getItems().addAll("AD", "AS", "AB", "AC", "AA");

        updateTable();

        tableActivities.getSelectionModel().selectedItemProperty().addListener((newSelection) -> {
            if (newSelection != null) {
                SessionData.setDiario((Diario) tableActivities.getSelectionModel().getSelectedItem());
            }
        });

        btnClose.setOnMouseClicked(event -> {
            System.exit(0);
        });

    }


    public void updateTable(){
        tableActivities.getItems().clear();
        tableActivities.getItems().addAll(filtrado.getResultList());
    }




    public void ActionAddActividad() {
        Diario diario = new Diario();
        diario.setAlumnoByAlumnoId(SessionData.getAlumno());
        diario.setActividad(comboActividades.getValue().toString());
        diario.setTipo(comboTipo.getValue().toString());
        diario.setHorasTrabajadas(Integer.valueOf(inputHorasTrabajas.getText()));
        diario.setObservaciones(inputObs.getText());

        s.beginTransaction();
        s.save(diario);
        s.getTransaction().commit();

        updateTable();

        inputHorasTrabajas.clear();
        inputObs.clear();
    }

    public void ActionBorrarActividad(ActionEvent actionEvent) {
        s.beginTransaction();
        s.delete(SessionData.getDiario());
        s.getTransaction().commit();

        updateTable();
    }



}