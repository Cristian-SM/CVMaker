package cl.bennu.labs.cv.domain;

public class Habilidad {
    private int id;
    private String nombre;
    private int categoria_id;
    private String nombre_categoria;
    private String desc_categoria;

    public Habilidad(int id, String nombre, int categoria_id) {
        this.id = id;
        this.nombre = nombre;
        this.categoria_id = categoria_id;
    }

    public Habilidad(int categoria_id, String nombre_categoria, String desc_categoria) {
        this.categoria_id = categoria_id;
        this.nombre_categoria = nombre_categoria;
        this.desc_categoria = desc_categoria;
    }

    public Habilidad() {
    }

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

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }
}
