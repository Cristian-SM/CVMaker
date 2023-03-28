package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Region;
import java.util.List;

public interface IRegionDao {

    Region get();

    List<Region> find();

    void delete(int id);

    void insert(String nombre);

    void update(int id, String nombre);

}
