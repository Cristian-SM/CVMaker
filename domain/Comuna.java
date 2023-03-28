package cl.bennu.labs.cv.domain;

public class Comuna {
    private Long id;
    private String nombre;
    private Long REGION_id;

    private String REGION_nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getREGION_id() {
        return REGION_id;
    }

    public void setREGION_id(Long REGION_id) {
        this.REGION_id = REGION_id;
    }

    public String getREGION_nombre() {
        return REGION_nombre;
    }

    public void setREGION_nombre(String REGION_nombre) {
        this.REGION_nombre = REGION_nombre;
    }
}
