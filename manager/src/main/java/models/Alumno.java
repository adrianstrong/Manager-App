package models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic
    @Column(name = "PasswordAlumno")
    private String passwordAlumno;
    @Basic
    @Column(name = "DNI")
    private String dni;
    @Basic
    @Column(name = "FechaNacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "ProfesorID", insertable = false, updatable = false)
    private Integer profesorId;
    @Basic
    @Column(name = "Telefono")
    private Integer telefono;
    @Basic
    @Column(name = "HorasTotalesDual")
    private Integer horasTotalesDual;
    @Basic
    @Column(name = "HorasTotalesFCT")
    private Integer horasTotalesFct;
    @Basic
    @Column(name = "Observaciones")
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "EmpresaID", referencedColumnName = "ID")
    private Empresa empresaByEmpresaId;
    @ManyToOne
    @JoinColumn(name = "ProfesorID", referencedColumnName = "ID")
    private Profesor profesorByProfesorId;
    @OneToMany(mappedBy = "alumnoByAlumnoId")
    private Collection<Diario> diariosById;

/*    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPasswordAlumno() {
        return passwordAlumno;
    }

    public void setPasswordAlumno(String passwordAlumno) {
        this.passwordAlumno = passwordAlumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getEmpresaId() {
        return empresaByEmpresaId.getId();
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaByEmpresaId.getId() = empresaByEmpresaId.getId();
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Integer getHorasTotalesDual() {
        return horasTotalesDual;
    }

    public void setHorasTotalesDual(Integer horasTotalesDual) {
        this.horasTotalesDual = horasTotalesDual;
    }

    public Integer getHorasTotalesFct() {
        return horasTotalesFct;
    }

    public void setHorasTotalesFct(Integer horasTotalesFct) {
        this.horasTotalesFct = horasTotalesFct;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Empresa getEmpresaByEmpresaId() {
        return empresaByEmpresaId;
    }

    public void setEmpresaByEmpresaId(Empresa empresaByEmpresaId) {
        this.empresaByEmpresaId = empresaByEmpresaId;
    }

    public Profesor getProfesorByProfesorId() {
        return profesorByProfesorId;
    }

    public void setProfesorByProfesorId(Profesor profesorByProfesorId) {
        this.profesorByProfesorId = profesorByProfesorId;
    }

    public Collection<Diario> getDiariosById() {
        return diariosById;
    }

    public void setDiariosById(Collection<Diario> diariosById) {
        this.diariosById = diariosById;
    }*/
}
