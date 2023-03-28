package cl.bennu.labs.cv.domain;

public class Contacto {
    private int numero_celular;
    private String correo;
    private int numero_fijo;
    private String linkedin;
    private String pagina_web;
    private String red_social;
    private String dirrecion;
    private int persona_rut;


    public int getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(int numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumero_fijo() {
        return numero_fijo;
    }

    public void setNumero_fijo(int numero_fijo) {
        this.numero_fijo = numero_fijo;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getRed_social() {
        return red_social;
    }

    public void setRed_social(String red_social) {
        this.red_social = red_social;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public int getPersona_rut() {
        return persona_rut;
    }

    public void setPersona_rut(int persona_rut) {
        this.persona_rut = persona_rut;
    }

}
