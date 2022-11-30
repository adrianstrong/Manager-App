package models;

import models.Alumno;

import java.util.Date;

public class Diario implements java.io.Serializable {

	private int id;
	private Alumno alumno;
	private Date fecha;
	private String tipo;
	private Integer horasTrabajadas;
	private String actividad;
	private String observaciones;

	public Diario() {
	}

	public Diario(int id) {
		this.id = id;
	}

	public Diario(int id, Alumno alumno, Date fecha, String tipo, Integer horasTrabajadas, String actividad,
			String observaciones) {
		this.id = id;
		this.alumno = alumno;
		this.fecha = fecha;
		this.tipo = tipo;
		this.horasTrabajadas = horasTrabajadas;
		this.actividad = actividad;
		this.observaciones = observaciones;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
