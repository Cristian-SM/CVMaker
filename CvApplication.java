package cl.bennu.labs.cv;

import cl.bennu.labs.cv.dao.iface.IPersonDao;
import cl.bennu.labs.cv.dao.impl.jdbc.CertificadoDao;
import cl.bennu.labs.cv.dao.impl.jdbc.ExpAcademicaDao;
import cl.bennu.labs.cv.dao.impl.jdbc.PersonDao;
import cl.bennu.labs.cv.domain.Certificado;
import cl.bennu.labs.cv.domain.ExpAcademica;
import cl.bennu.labs.cv.domain.Person;

import javax.swing.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CvApplication {

    public static void main(String[] args) {

        //PRUEBAS EXP ACADEMICA
        ExpAcademicaDao eDao = new ExpAcademicaDao();
        //ExpAcademica a = null;
        /*
        a = eDao.get(1); //OBTIENE PERO HAY QUE DARLE UN ID
        System.out.println("ID:             " + a.getId());
        System.out.println("Grado:          " + a.getGrado());
        System.out.println("Descripción:    " + a.getDescripcion());
        System.out.println("Fecha Inicio:   " + a.getFecha_inicio());
        System.out.println("Fecha Fin:      " + a.getFecha_fin());
        System.out.println("ID Institución: " + a.getId_institucion());
        System.out.println("ID CV:          " + a.getCurriculum_id());
        */

        //AGREGA
        ExpAcademica a= new ExpAcademica();
        a.setId(5); //agrega no toma en cuenta el id
        a.setGrado("Instituciónpara ELIMINAR");
        a.setDescripcion("ALIMINAR");
        a.setFecha_inicio("1999-03-23");
        a.setFecha_fin("2020-03-23");
        a.setId_institucion(1);
        a.setCurriculum_id(1);
        //System.out.println("ID ACTUALIZAR: "+a.getId() + " " + a.getDescripcion());
        //eDao.insert(a); //NO TOMA EN CUENTA LA ID .setId(0);
        //eDao.update(a); //HAY QUE ASIGNARLE EL ID .setId(5);
        //eDao.delete(5); //HAY QUE ASIGNARLE EL ID .setId(5);

        List<ExpAcademica> expAcaList = eDao.find();
        for (ExpAcademica expAcademica : expAcaList) {
            System.out.println("ID:             " + expAcademica.getId());
            System.out.println("Grado:          " + expAcademica.getGrado());
            System.out.println("Descripción:    " + expAcademica.getDescripcion());
            System.out.println("Fecha Inicio:   " + expAcademica.getFecha_inicio());
            System.out.println("Fecha Fin:      " + expAcademica.getFecha_fin());
            System.out.println("ID Institución: " + expAcademica.getId_institucion());
            System.out.println("ID CV:          " + expAcademica.getCurriculum_id()+"\n");
        }

        //PRUEBAS DE CERTIFICADOS
        /*
        CertificadoDao cDao = new CertificadoDao();
        Certificado c = new Certificado();
        c.setId(6);
        c.setNombre("Certificado 2.0 que se modifica");
        c.setFecha("2020-01-01");
        c.setCurriculum_id(1);

        //cDao.insert(c); //PARA AGREGAR NO TOMA EN CUENTA EL c.setID
        //cDao.update(c); //PARA ACTUALIZAR SI TIENE QUE INGRESAR EL c.setID
        //cDao.delete(6); //PARA ELIMINAR PRIBERO DEBE ESTAR CREADO

        //BUSCA UN CERTIFICADO PERO DEBE ESTAR CREADO

        Certificado cert = cDao.get(2);
        System.out.println("ID:            " + cert.getId());
        System.out.println("Nombre:        " + cert.getNombre());
        System.out.println("Fecha:         " + cert.getFecha());
        System.out.println("ID Curriculum: " + cert.getCurriculum_id()+"\n");


        List<Certificado> certList = cDao.find();
        for (Certificado cert : certList) {
            System.out.println("ID:            " + cert.getId());
            System.out.println("Nombre:        " + cert.getNombre());
            System.out.println("Fecha:         " + cert.getFecha());
            System.out.println("ID Curriculum: " + cert.getCurriculum_id()+"\n");
        }
        */
    }
}
