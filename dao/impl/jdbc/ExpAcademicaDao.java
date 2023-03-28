package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IExpAcademicaDao;
import cl.bennu.labs.cv.domain.Certificado;
import cl.bennu.labs.cv.domain.ExpAcademica;
import cl.bennu.labs.cv.domain.Person;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpAcademicaDao implements IExpAcademicaDao {
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    Connection connection = null;
    ExpAcademica ea = null;
    @Override
    public ExpAcademica get(int id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM EXP_ACADEMICA WHERE id = ? ";

            // preparar la sentencia
            pst = connection.prepareStatement(sql);

            pst.setInt(1,id);

            rs = pst.executeQuery();

            while (rs.next()) {
                ea = new ExpAcademica();
                ea.setId(rs.getInt(1));
                ea.setGrado(rs.getString(2));
                ea.setDescripcion(rs.getString(3));
                ea.setFecha_inicio(rs.getString(4));
                ea.setFecha_fin(rs.getString(5));
                ea.setId_institucion(rs.getInt(6));
                ea.setCurriculum_id(rs.getInt(7));
            }

        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
            return ea;
        }
    }

    @Override
    public List<ExpAcademica> find() {
        List<ExpAcademica> lista = new ArrayList<>();
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM EXP_ACADEMICA";

            // preparar la sentencia
            st = connection.createStatement();

            // ejecuto consulta
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ExpAcademica ea = new ExpAcademica();
                ea.setId(rs.getInt(1));
                ea.setGrado(rs.getString(2));
                ea.setDescripcion(rs.getString(3));
                ea.setFecha_inicio(rs.getString(4));
                ea.setFecha_fin(rs.getString(5));
                ea.setId_institucion(rs.getInt(6));
                ea.setCurriculum_id(rs.getInt(7));
                lista.add(ea);
            }
        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
        return lista;
    }

    @Override
    public void delete(int id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "DELETE FROM EXP_ACADEMICA WHERE id = ? ";

            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();

        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void insert(ExpAcademica a) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "INSERT INTO EXP_ACADEMICA (grado, descripcion, fecha_inicio, fecha_fin, INSTITUCION_id, CURRICULUM_id) " +
                    " VALUES (?,?,?,?,?,?) ";

            pst = connection.prepareStatement(sql);
            pst.setString(1, a.getGrado());
            pst.setString(2, a.getDescripcion());
            pst.setString(3, a.getFecha_inicio());
            pst.setString(4, a.getFecha_fin());
            pst.setInt(5, a.getId_institucion());
            pst.setInt(6, a.getCurriculum_id());
            pst.executeUpdate();

        }catch (Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void update(ExpAcademica a) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "UPDATE EXP_ACADEMICA SET grado = ? , descripcion = ? ," +
                    "                    fecha_inicio = ? , fecha_fin = ? ," +
                    "                    INSTITUCION_id = ? , CURRICULUM_id = ?" +
                    "                    WHERE id = ?";

            pst = connection.prepareStatement(sql);

            pst.setString(1, a.getGrado());
            pst.setString(2, a.getDescripcion());
            pst.setString(3, a.getFecha_inicio());
            pst.setString(4, a.getFecha_fin());
            pst.setInt(5, a.getId_institucion());
            pst.setInt(6, a.getCurriculum_id());
            pst.setInt(7, a.getId());

            pst.executeUpdate();

        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }
}
