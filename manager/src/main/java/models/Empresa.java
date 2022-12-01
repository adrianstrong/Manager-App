package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Telefono")
    private Integer telefono;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Responsable")
    private String responsable;
    @Basic
    @Column(name = "Observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "empresaByEmpresaId")
    private Collection<Alumno> alumnosById;

    public int getId() {
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa that = (Empresa) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email) && Objects.equals(responsable, that.responsable) && Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, telefono, email, responsable, observaciones);
    }

    public Collection<Alumno> getAlumnosById() {
        return alumnosById;
    }

    public void setAlumnosById(Collection<Alumno> alumnosById) {
        this.alumnosById = alumnosById;
    }
}
