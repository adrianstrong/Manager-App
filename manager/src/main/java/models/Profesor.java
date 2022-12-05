package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "profesor")
public class Profesor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    public int id;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic
    @Column(name = "PasswordProfesor")
    private String passwordProfesor;
    @Basic
    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "profesorByProfesorId")
    public Collection<Alumno> alumnosById;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPasswordProfesor() {
        return passwordProfesor;
    }

    public void setPasswordProfesor(String passwordProfesor) {
        this.passwordProfesor = passwordProfesor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor that = (Profesor) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(passwordProfesor, that.passwordProfesor) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, passwordProfesor, email);
    }

    public Collection<Alumno> getAlumnosById() {
        return alumnosById;
    }

    public void setAlumnosById(Collection<Alumno> alumnosById) {
        this.alumnosById = alumnosById;
    }
}
