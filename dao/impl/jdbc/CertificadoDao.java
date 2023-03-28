package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.ICertificadoDao;
import cl.bennu.labs.cv.domain.Certificado;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CertificadoDao implements ICertificadoDao {
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    Connection connection = null;
    Certificado c = null;
    @Override
    public Certificado get(int id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM CERTIFICADO WHERE CURRICULUM_id = ? ";
            // preparar la sentencia
            pst = connection.prepareStatement(sql);

            pst.setInt(1,id);

            rs = pst.executeQuery();

            while (rs.next()) {
                c = new Certificado();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setFecha(rs.getString(3));
                c.setCurriculum_id(rs.getInt(4));
            }

        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
            return c;
        }
    }

    @Override
    public List<Certificado> find(int id) {
        List<Certificado> lista = new ArrayList<>();
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM CERTIFICADO WHERE CURRICULUM_id = ?";

            pst = connection.prepareStatement(sql);

            pst.setInt(1,id);

            rs = pst.executeQuery();

            while (rs.next()) {
                Certificado c = new Certificado();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setFecha(rs.getString(3));
                c.setCurriculum_id(rs.getInt(4));
                lista.add(c);
            }
        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return lista;
    }

    @Override
    public void delete(int id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "DELETE FROM CERTIFICADO WHERE id = ? ";

            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();

        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void insert(Certificado c) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "INSERT INTO CERTIFICADO (nombre, fecha, CURRICULUM_id) VALUES(?,?,?)";
            pst = connection.prepareStatement(sql);
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getFecha());
            pst.setInt(3, c.getCurriculum_id());
            pst.executeUpdate();

        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void update(Certificado c) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "UPDATE CERTIFICADO SET nombre = ? , fecha = ? , " +
                    "CURRICULUM_id = ? WHERE id = ? ";

            pst = connection.prepareStatement(sql);

            pst.setString(1, c.getNombre());
            pst.setString(2, c.getFecha());
            pst.setInt(3, c.getCurriculum_id());
            pst.setInt(4, c.getId());

            pst.executeUpdate();

        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
    }
}
