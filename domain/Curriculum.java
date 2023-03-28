package cl.bennu.labs.cv.domain;

public class Curriculum {
    private int id;
    private String fecha_creacion;
    private String codigo_descarga;
    private String codigo_qr;
    private int PERSONA_rut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getCodigo_descarga() {
        return codigo_descarga;
    }

    public void setCodigo_descarga(String codigo_descarga) {
        this.codigo_descarga = codigo_descarga;
    }

    public String getCodigo_qr() {
        return codigo_qr;
    }

    public void setCodigo_qr(String codigo_qr) {
        this.codigo_qr = codigo_qr;
    }

    public int getPERSONA_rut() {
        return PERSONA_rut;
    }

    public void setPERSONA_rut(int PERSONA_rut) {
        this.PERSONA_rut = PERSONA_rut;
    }
}