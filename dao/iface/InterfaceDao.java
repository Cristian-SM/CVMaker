package cl.bennu.labs.cv.dao.iface;

import java.util.List;
public interface InterfaceDao <T> {
    T get(Long id);

    List<T> find();

    void delete(Long id);

    void insert(T object);

    void update(Long id, String value);

}
