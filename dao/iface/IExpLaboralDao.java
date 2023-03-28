package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.ExpLaboral;

import java.util.List;

public interface IExpLaboralDao {
    
    ExpLaboral get(int id);
    
    List<ExpLaboral> find(int id);
    
    void delete(int id);

    void insert(String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id);

    void update(String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id, int id);
}
