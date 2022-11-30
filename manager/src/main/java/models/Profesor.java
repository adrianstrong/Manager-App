package models;

import java.util.HashSet;
import java.util.Set;

public class Profesor implements java.io.Serializable {

	private int id;
	private String nombre;
	private String apellidos;
	private String passwordProfesor;
	private String email;
	private Set alumnos = new HashSet(0);

	public Profesor() {
	}

	public Profesor(int id) {
		this.id = id;
	}

	public Profesor(int id, String nombre, String apellidos, String passwordProfesor, String email, Set alumnos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwordProfesor = passwordProfesor;
		this.email = email;
		this.alumnos = alumnos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPasswordProfesor() {
		return this.passwordProfesor;
	}

	public void setPasswordProfesor(String passwordProfesor) {
		this.passwordProfesor = passwordProfesor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set alumnos) {
		this.alumnos = alumnos;
	}

}
