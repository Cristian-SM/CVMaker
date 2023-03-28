package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Persona;

import java.util.List;

public interface IPersonaDao extends InterfaceDao<Persona> {
    Persona get(Long id);

    List<Persona> find();

    void delete(Long id);

    void insert(Persona persona);

    void update(Long id, String value);

}
