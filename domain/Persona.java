package cl.bennu.labs.cv.domain;

import java.sql.Blob;

public class Persona {

    private Long rut;
    private char dv;
    private String nombreCompleto;
    private String fechaNacimiento;
    private Blob foto;
    private Integer estadoCivil;
    private Integer sexo;
    private Integer nacionalidad;
    private Integer comuna;

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Integer nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getComuna() {
        return comuna;
    }

    public void setComuna(Integer comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return  "Rut = " + rut + "-" + dv +
                ", Nombre Completo = " + nombreCompleto +
                ", Fecha Nacimiento = " + fechaNacimiento +
                ", Foto = " + foto +
                ", Estado Civil = " + estadoCivil +
                ", Sexo = " + sexo +
                ", Nacionalidad = " + nacionalidad +
                ", Comuna = " + comuna;
    }
}
