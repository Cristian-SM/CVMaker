package cl.bennu.labs.cv;

import cl.bennu.labs.cv.dao.impl.jdbc.*;
import cl.bennu.labs.cv.domain.*;

import java.sql.SQLOutput;
import java.util.List;

public class CvApplication {

    public static void main(String[] args) {

        //PRUEBAS CURRICULUM
        System.out.println("************************************");
        System.out.println("          DATOS CVMAKER");
        System.out.println("************************************");
        Curriculum c = new Curriculum();
        CurriculumDao cDao = new CurriculumDao();
        c = cDao.get(1);
        int id_curriculum = c.getId();
        System.out.println("Id Curriculum   : " + id_curriculum);
        System.out.println("Fecha Creación  : " + c.getFecha_creacion());
        System.out.println("Código Descarga : " + c.getCodigo_descarga());
        System.out.println("Código QR       : " + c.getCodigo_qr());
        System.out.println("RUT             : " + c.getPERSONA_rut());

        System.out.println("************************************");
        System.out.println("          DATOS PERSONALES");
        System.out.println("************************************");

        PersonaDao pDao = new PersonaDao();
        Persona p = pDao.get((long) c.getPERSONA_rut());
        String rut_completo = p.getRut() + "-" + p.getDv();
        System.out.println("Rut Completo    : " + rut_completo);
        System.out.println("Nombre Completo : " + p.getNombreCompleto());
        System.out.println("Fecha Nacimiento: " + p.getFechaNacimiento());
        System.out.println("Foto            : " + p.getFoto());
        System.out.println("Estado Civil    : " + p.getEstadoCivil());
        System.out.println("Sexo            : " + p.getSexo());

        System.out.println("************************************");
        System.out.println("          DATOS CONTACTO");
        System.out.println("************************************");
        ContactoDao conDao = new ContactoDao();
        Contacto contacto = conDao.get( c.getPERSONA_rut() );
        System.out.println("Número Contacto : " + contacto.getNumero_celular());
        System.out.println("Correo          : " + contacto.getCorreo());
        System.out.println("Número Fijo     : " + contacto.getNumero_fijo());
        System.out.println("Linkedin        : " + contacto.getLinkedin());
        System.out.println("Página Web      : " + contacto.getPagina_web());
        System.out.println("Red Social      : " + contacto.getRed_social());
        System.out.println("Dirección       : " + contacto.getDirrecion());
        System.out.println("Rut de Contacto : " + contacto.getPersona_rut()+"\n");


        System.out.println("************************************");
        System.out.println("         EXPERIENCIA ACADEMICA");
        System.out.println("************************************");
        ExpAcademicaDao eDao = new ExpAcademicaDao();

        List<ExpAcademica> expAcaList = eDao.find(id_curriculum);
        for (ExpAcademica expAcademica : expAcaList) {
            System.out.println("ID            : " + expAcademica.getId());
            System.out.println("Grado         : " + expAcademica.getGrado());
            System.out.println("Descripción   : " + expAcademica.getDescripcion());
            System.out.println("Fecha Inicio  : " + expAcademica.getFecha_inicio());
            System.out.println("Fecha Fin     : " + expAcademica.getFecha_fin());
            System.out.println("ID Institución: " + expAcademica.getId_institucion());
            System.out.println("Curriculum    : " + expAcademica.getCurriculum_id()+"\n");
        }

        System.out.println("************************************");
        System.out.println("            CERTIFICADOS");
        System.out.println("************************************");
        System.out.println("CERTIFICADOS  DE : " + rut_completo);
        CertificadoDao cerDao = new CertificadoDao();
        List<Certificado> certList = cerDao.find(id_curriculum);
        for (Certificado cert : certList) {
            System.out.println("Id Certificado: " + cert.getId());
            System.out.println("Nombre        : " + cert.getNombre());
            System.out.println("Fecha         : " + cert.getFecha());
            System.out.println("ID Curriculum : " + cert.getCurriculum_id()+"\n");
        }

        System.out.println("************************************");
        System.out.println("          EXPERIENCIA LABORAL");
        System.out.println("************************************");
        ExpLaboralDao expLab = new ExpLaboralDao();
        List<ExpLaboral> expList = expLab.find(id_curriculum);
        for (ExpLaboral eLab : expList) {
            System.out.println("Id Exp Lab    : " + eLab.getId());
            System.out.println("Area          : " + eLab.getArea());
            System.out.println("Cargo         : " + eLab.getCargo());
            System.out.println("Descripción   : " + eLab.getDescripcion());
            System.out.println("Fecha Inicio  : " + eLab.getFecha_inicio());
            System.out.println("Fecha Termino : " + eLab.getFecha_termino());
            System.out.println("ID Curriculum : " + eLab.getCurriculum_id()+"\n");
        }

        System.out.println("************************************");
        System.out.println("            HABILIDADES");
        System.out.println("************************************");
        HabilidadDao habDao = new HabilidadDao();
        List<Habilidad> habList = habDao.find();
        for (Habilidad hab : habList) {
            System.out.println("Id Habilidad  : " + hab.getId());
            System.out.println("Nombre Hab    : " + hab.getNombre());
            System.out.println("Id Categoria  : " + hab.getCategoria_id());
            System.out.println("Nombre Cat    : " + hab.getNombre_categoria());
            System.out.println("Desc Categoria: " + hab.getDesc_categoria()+"\n");
        }
        /*
        System.out.println("************************************");
        System.out.println("         VER COMUNAS Y REGIONES");
        System.out.println("************************************");
        ComunaDao comDao = new ComunaDao();
        RegionDao regDao = new RegionDao();

        List<Comuna> comList =  comDao.find();
        List<Region> regList =  regDao.find();
        System.out.println("COMUNAS");
        for (Comuna com : comList) {
            System.out.println("Id Comuna     : " + com.getId());
            System.out.println("Nombre Comuna : " + com.getNombre());
            System.out.println("Id Region     : " + com.getREGION_id());
            System.out.println("Nombre Region : " + com.getREGION_nombre()+"\n");
        }
        System.out.println("REGIONES");
        for (Region reg : regList) {
            System.out.println("Id Region     : " + reg.getId());
            System.out.println("Nombre Region : " + reg.getNombre()+"\n");
        }
        */

    }
}