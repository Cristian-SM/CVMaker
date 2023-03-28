package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.ExpAcademica;

import java.util.List;

public interface IExpAcademicaDao {
    ExpAcademica get(int id);

    List<ExpAcademica> find();

    void delete(int id);

    void insert(ExpAcademica a);

    void update(ExpAcademica a);
}
