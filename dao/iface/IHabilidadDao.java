package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Habilidad;

import java.util.ArrayList;
import java.util.List;

public interface IHabilidadDao {

    Habilidad get(int id);

    List<Habilidad> find();

    void deleteHab(int id);
    void deleteCat();
    void insertHab(String nombre, int categoria_id);
    void insertCat();
    void updateHab(String nombre, int categoria_id, int id);
    void updateCat();
}
