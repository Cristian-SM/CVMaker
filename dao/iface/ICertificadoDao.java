package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Certificado;
import cl.bennu.labs.cv.domain.ExpAcademica;

import java.util.List;

public interface ICertificadoDao {
    Certificado get(int id);

    List<Certificado> find();

    void delete(int id);

    void insert(Certificado c);

    void update(Certificado c);
}
