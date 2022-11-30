package models;

import java.util.HashSet;
import java.util.Set;

public class Empresa implements java.io.Serializable {

	private int id;
	private String nombre;
	private Integer telefono;
	private String email;
	private String responsable;
	private String observaciones;
	private Set alumnos = new HashSet(0);

	public Empresa() {
	}

	public Empresa(int id) {
		this.id = id;
	}

	public Empresa(int id, String nombre, Integer telefono, String email, String responsable, String observaciones,
			Set alumnos) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.responsable = responsable;
		this.observaciones = observaciones;
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

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set alumnos) {
		this.alumnos = alumnos;
	}

}
