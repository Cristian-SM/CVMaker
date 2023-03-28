package cl.bennu.labs.cv.domain;

import java.util.Date;

public class ExpAcademica {
    private int id;
    private String grado;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    private int id_institucion;
    private int curriculum_id;
    /*
    private Comuna id;
    private Curriculum id

     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public int getCurriculum_id() {
        return curriculum_id;
    }

    public void setCurriculum_id(int curriculum_id) {
        this.curriculum_id = curriculum_id;
    }
}
