package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Comuna;
import java.util.List;

public interface IComunaDao {
    Comuna get ();

    List<Comuna> find();

    void delete(int id);

    void insert(String nombre, int REGION_id);

    void update(int id, String nombre);

    List<Comuna> findByRegion(int REGION_id);
}
