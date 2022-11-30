package models;

import models.Profesor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Alumno implements java.io.Serializable {

	private int id;
	private Empresa empresa;
	private Profesor profesor;
	private String nombre;
	private String apellidos;
	private String passwordAlumno;
	private String dni;
	private Date fechaNacimiento;
	private String email;
	private Integer telefono;
	private Integer horasTotalesDual;
	private Integer horasTotalesFct;
	private String observaciones;
	private Set diarios = new HashSet(0);

	public Alumno() {
	}

	public Alumno(int id) {
		this.id = id;
	}

	public Alumno(int id, Empresa empresa, Profesor profesor, String nombre, String apellidos, String passwordAlumno,
			String dni, Date fechaNacimiento, String email, Integer telefono, Integer horasTotalesDual,
			Integer horasTotalesFct, String observaciones, Set diarios) {
		this.id = id;
		this.empresa = empresa;
		this.profesor = profesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwordAlumno = passwordAlumno;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.horasTotalesDual = horasTotalesDual;
		this.horasTotalesFct = horasTotalesFct;
		this.observaciones = observaciones;
		this.diarios = diarios;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
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

	public String getPasswordAlumno() {
		return this.passwordAlumno;
	}

	public void setPasswordAlumno(String passwordAlumno) {
		this.passwordAlumno = passwordAlumno;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getHorasTotalesDual() {
		return this.horasTotalesDual;
	}

	public void setHorasTotalesDual(Integer horasTotalesDual) {
		this.horasTotalesDual = horasTotalesDual;
	}

	public Integer getHorasTotalesFct() {
		return this.horasTotalesFct;
	}

	public void setHorasTotalesFct(Integer horasTotalesFct) {
		this.horasTotalesFct = horasTotalesFct;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set getDiarios() {
		return this.diarios;
	}

	public void setDiarios(Set diarios) {
		this.diarios = diarios;
	}

}
