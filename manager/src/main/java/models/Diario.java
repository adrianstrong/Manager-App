package models;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "diario")
public class Diario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "AlumnoID" , insertable = false, updatable = false)
    private Integer alumnoId;
    @Basic
    @Column(name = "Fecha")
    private Date fecha;
    @Basic
    @Column(name = "Tipo")
    private String tipo;
    @Basic
    @Column(name = "HorasTrabajadas")
    private Integer horasTrabajadas;
    @Basic
    @Column(name = "Actividad")
    private String actividad;
    @Basic
    @Column(name = "Observaciones")
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "AlumnoID", referencedColumnName = "ID")
    private Alumno alumnoByAlumnoId;

    @Formula(" horas trabajas - 200 ")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Alumno getAlumnoByAlumnoId() {
        return alumnoByAlumnoId;
    }

    public void setAlumnoByAlumnoId(Alumno alumnoByAlumnoId) {
        this.alumnoByAlumnoId = alumnoByAlumnoId;
    }
}
