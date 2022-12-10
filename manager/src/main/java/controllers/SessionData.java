package controllers;

import models.Diario;
import models.Alumno;
import models.Empresa;
import models.Profesor;

public class SessionData {
    private static Alumno alumno;
    private static Profesor profesor;
    private static Empresa empresa;
    private static Diario diario;
    private static Boolean contextoadmin;
    private static Boolean cambios;

    public static Alumno getAlumno() {
        return alumno;
    }

    public static void setAlumno(Alumno alumno) {
        SessionData.alumno = alumno;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        SessionData.profesor = profesor;
    }

    public static Empresa getEmpresa() {
        return empresa;
    }

    public static void setEmpresa(Empresa empresa) {
        SessionData.empresa = empresa;
    }

    public static Diario getDiario() {
        return diario;
    }

    public static void setDiario(Diario diario) {
        SessionData.diario = diario;
    }

    public static Boolean getContextoAdmin() {
        return contextoadmin;
    }

    public static void setContextoAdmin(Boolean contextoadmin) {
        SessionData.contextoadmin = contextoadmin;
    }

    public static Boolean getCambios() {
        return cambios;
    }

    public static void setCambios(Boolean cambios) {
        SessionData.cambios = cambios;
    }
}