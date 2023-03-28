package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Person;

import java.util.List;

public interface IPersonDao {

    Person get();

    List<Person> find();

    void delete();

    void insert();

    void update();

}
