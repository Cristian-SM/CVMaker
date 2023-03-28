package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Curriculum;

import java.util.List;

public interface ICurriculumDao {
    Curriculum get(int id);
    List<Curriculum> find();

    void delete(int id);

    void insert(Curriculum c);

    void update(Curriculum c);
}
