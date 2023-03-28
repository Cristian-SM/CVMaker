package cl.bennu.labs.cv.domain;

public class ExpLaboral {
    // Variables
    private int id;
    private String empresa;
    private String area;
    private String cargo;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_termino;
    private int curriculum_id;

    public ExpLaboral(int id, String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id) {
        this.id = id;
        this.empresa = empresa;
        this.area = area;
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.curriculum_id = curriculum_id;
    }

    public ExpLaboral() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public int getCurriculum_id() {
        return curriculum_id;
    }

    public void setCurriculum_id(int curriculum_id) {
        this.curriculum_id = curriculum_id;
    }
}
