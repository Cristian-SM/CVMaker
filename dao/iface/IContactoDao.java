package cl.bennu.labs.cv.dao.iface;

import cl.bennu.labs.cv.domain.Contacto;

import java.util.List;

public interface IContactoDao {



    Contacto get(int rut);

    List<Contacto> find();

    void delete(int rut);

    void insert(int numero_celular, String correo, int numero_fijo, String linkedin,String pagina_web,String red_social, String direccion, int PERSONA_rut);

    void update(int numero_celular, int PERSONA_rut);

}
