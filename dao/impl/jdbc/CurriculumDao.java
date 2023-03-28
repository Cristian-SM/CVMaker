package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.ICurriculumDao;
import cl.bennu.labs.cv.domain.Certificado;
import cl.bennu.labs.cv.domain.Curriculum;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDao implements ICurriculumDao {
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    Connection connection = null;
    Curriculum c = null;
    @Override
    public Curriculum get(int id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM CURRICULUM WHERE id = ? ";
            // preparar la sentencia
            pst = connection.prepareStatement(sql);

            pst.setInt(1,id);

            rs = pst.executeQuery();

            while (rs.next()) {
                c = new Curriculum();
                c.setId(rs.getInt(1));
                c.setFecha_creacion(rs.getString(2));
                c.setCodigo_descarga(rs.getString(3));
                c.setCodigo_qr(rs.getString(4));
                c.setPERSONA_rut(rs.getInt(5));
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
    public List<Curriculum> find() {
        List<Curriculum> lista = new ArrayList<>();
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "SELECT * FROM CURRICULUM";

            // preparar la sentencia
            st = connection.createStatement();

            // ejecuto consulta
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Curriculum c = new Curriculum();
                c.setId(rs.getInt(1));
                c.setFecha_creacion(rs.getString(2));
                c.setCodigo_descarga(rs.getString(3));
                c.setCodigo_qr(rs.getString(4));
                c.setPERSONA_rut(rs.getInt(5));
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

            String sql = "DELETE FROM CURRICULUM WHERE id = ? ";

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
    public void insert(Curriculum c) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "insert into CURRICULUM values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setInt(1, c.getId());
            statement.setString(2, c.getFecha_creacion());
            statement.setString(3, c.getCodigo_descarga());
            statement.setString(4, c.getCodigo_qr());
            statement.setInt(5, c.getPERSONA_rut());

            //Ingresando curriculum
            System.out.println("Ingresando contacto");
            statement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Violación de restricción de integridad de datos: " + e.getMessage());
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
    public void update(Curriculum c) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "update CURRICULUM set codigo_descarga = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setString(1, c.getCodigo_descarga());
            statement.setInt(2, c.getId());

            //Actualizando curriculum
            System.out.println("Actualizando curriculum");
            statement.executeUpdate();


        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Violación de restricción de integridad de datos: " + e.getMessage());
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
