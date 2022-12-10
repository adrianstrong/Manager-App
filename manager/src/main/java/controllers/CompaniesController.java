package controllers;

import csur.app.manager.App;
import csur.app.manager.HibernateUtil;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.Alumno;
import models.Empresa;
import org.hibernate.Session;

import javax.persistence.Query;
import java.net.URL;
import java.util.ResourceBundle;

public class CompaniesController implements Initializable {

    public TableView tableCompanies;
    public TableView tableAlumnos;
    public TableColumn colComID;
    public TableColumn colComNam;
    public TableColumn colComTlf;
    public TableColumn colComEmail;
    public TableColumn colComResp;
    public TableColumn colComObs;
    public TableColumn colStID;
    public TableColumn colStName;
    public TableColumn colStLName;
    public TableColumn colStDNI;
    public TableColumn colStDate;
    public TableColumn colStTlf;
    public Label lblNombre;
    public Label lblTelefono;
    public Label lblEmail;
    public Label lblResponsable;
    public Label lblObs;
    public Label lblNombreAlumno;
    public Label lblApellidosAlumno;
    public Label lblEmailAlumno;
    public Label lblTelefonoAlumno;
    static Session s = HibernateUtil.getSessionFactory().openSession();
    public ImageView btnGoBack;
    public ImageView btnClose;
    public ImageView btnRefresh;
    public Label lblUsuario;

    Query empresas;
    Query alumnos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUsuario.setText(SessionData.getProfesor().getEmail());

        colComID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colComNam.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colComTlf.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        colComEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colComResp.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        colComObs.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        empresas = s.createQuery("from Empresa");
        tableCompanies.setItems(FXCollections.observableArrayList(empresas.getResultList()));

        colStID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colStLName.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        colStDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colStDate.setCellValueFactory(new PropertyValueFactory<>("FechaNacimiento"));
        colStTlf.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        alumnos = s.createQuery("from Alumno");
        tableAlumnos.setItems(FXCollections.observableArrayList(alumnos.getResultList()));

        btnGoBack.setOnMouseClicked(event -> {
            App.newStage("Home.fxml");
            btnGoBack.getScene().getWindow().hide();
            SessionData.setAlumno(null);
            SessionData.setEmpresa(null);
        });

        btnClose.setOnMouseClicked(event -> {
            System.exit(0);
        });

        btnRefresh.setOnMouseClicked(event -> {
            empresas = s.createQuery("from Empresa");
            tableCompanies.setItems(FXCollections.observableArrayList(s.createQuery("from Empresa").getResultList()));
            alumnos = s.createQuery("from Alumno");
            tableAlumnos.setItems(FXCollections.observableArrayList(s.createQuery("from Alumno").getResultList()));
        });

        tableCompanies.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                lblNombre.setText(((Empresa) newSelection).getNombre());
                lblTelefono.setText(((Empresa) newSelection).getTelefono().toString());
                lblEmail.setText(((Empresa) newSelection).getEmail());
                lblResponsable.setText(((Empresa) newSelection).getResponsable());
                lblObs.setText(((Empresa) newSelection).getObservaciones());
            }
        });

        tableAlumnos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                lblNombreAlumno.setText(((Alumno) newSelection).getNombre());
                lblApellidosAlumno.setText(((Alumno) newSelection).getApellidos());
                lblEmailAlumno.setText(((Alumno) newSelection).getEmail());
                lblTelefonoAlumno.setText(((Alumno) newSelection).getTelefono().toString());
            }
        });

    }

    public void updateTable() {
        tableCompanies.getItems().clear();
        tableAlumnos.getItems().clear();

        tableCompanies.setItems(FXCollections.observableArrayList(empresas.getResultList()));
        tableAlumnos.setItems(FXCollections.observableArrayList(alumnos.getResultList()));

    }

   public void asignarEmpresa() {
        if (tableAlumnos.getSelectionModel().getSelectedItem() != null && tableCompanies.getSelectionModel().getSelectedItem() != null) {
            Alumno alumno = (Alumno) tableAlumnos.getSelectionModel().getSelectedItem();
            Empresa empresa = (Empresa) tableCompanies.getSelectionModel().getSelectedItem();
            alumno.setEmpresaByEmpresaId(empresa);
            s.beginTransaction();
            s.update(alumno);
            s.getTransaction().commit();
            updateTable();
        }
    }

    public void agregarEmpresa() {
        App.newStage("NuevaEmpresa.fxml");
    }

    public void eliminarEmpresa(ActionEvent actionEvent) {
        if (tableCompanies.getSelectionModel().getSelectedItem() != null) {
            Empresa empresa = (Empresa) tableCompanies.getSelectionModel().getSelectedItem();
            s.beginTransaction();
            s.delete(empresa);
            s.getTransaction().commit();
            updateTable();
        }
    }

    public void modificarEmpresa(ActionEvent actionEvent) {
        if (tableCompanies.getSelectionModel().getSelectedItem() != null) {
            SessionData.setEmpresa((Empresa) tableCompanies.getSelectionModel().getSelectedItem());
            App.newStage("ModificarEmpresa.fxml");
        }
    }

}
