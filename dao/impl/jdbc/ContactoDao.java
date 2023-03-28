package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IContactoDao;
import cl.bennu.labs.cv.domain.Contacto;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLTimeoutException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDao implements IContactoDao {
    @Override
    public Contacto get(int PERSONA_rut) {
        Contacto contacto = new Contacto();
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();

            // Se crea el objeto PreparedStatement con la consulta
            String sql = "select * from CONTACTO where PERSONA_rut = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setInt(1, PERSONA_rut);

            //Guardar el resultado
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //Guardando datos
                System.out.println("Obteniendo datos");
                contacto.setNumero_celular(resultSet.getInt(1));
                contacto.setCorreo(resultSet.getString(2));
                contacto.setNumero_fijo(resultSet.getInt(3));
                contacto.setLinkedin(resultSet.getString(4));
                contacto.setPagina_web(resultSet.getString(5));
                contacto.setRed_social(resultSet.getString(6));
                contacto.setDirrecion(resultSet.getString(7));
                contacto.setPersona_rut(resultSet.getInt(8));
                /*
                System.out.println("|`````````````````````````````````````````````````````````|");
                System.out.println("Datos de contacto de : " + resultSet.getInt(8));
                System.out.println("-----------------------------------------------------------");
                System.out.println("Correo electronico : " + resultSet.getString(2));
                System.out.println("Numero Celular : " + resultSet.getInt(1));
                System.out.println("Numero Fijo : " + resultSet.getInt(3));
                System.out.println("Linkedin : " + resultSet.getString(4));
                System.out.println("Pagina Web : " + resultSet.getString(5));
                System.out.println("Red Social : " + resultSet.getString(6));
                System.out.println("Direccion : " + resultSet.getString(7));
                System.out.println("|_________________________________________________________|");


                 */
            } else {
                System.out.println("Contacto no encontrado");
            }

        } catch (SQLSyntaxErrorException e) {
            System.err.println("Error de sintaxis en la consulta SQL: " + e.getMessage());
        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } //catch (SQLException e) {
        //   System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        //}
        catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
        } finally {
        ConnectionUtils.closeConnection(connection);
    }
        return contacto;
    }

    @Override
    public List<Contacto> find() {
        List<Contacto> contactoList = new ArrayList<>();;
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "select * from CONTACTO";

            // preparar la sentencia
            Statement statement = connection.createStatement();

            // ejecuto consulta
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contacto contacto = new Contacto();
                contacto.setNumero_celular(resultSet.getInt(1));
                contacto.setCorreo(resultSet.getString(2));
                contacto.setNumero_fijo(resultSet.getInt(3));
                contacto.setLinkedin(resultSet.getString(4));
                contacto.setPagina_web(resultSet.getString(5));
                contacto.setRed_social(resultSet.getString(6));
                contacto.setDirrecion(resultSet.getString(7));
                contacto.setPersona_rut(resultSet.getInt(8));

                contactoList.add(contacto);
            }
        } catch (Exception e) {
            System.out.println("Fail connexion" + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return contactoList;
    }



    @Override
    public void delete(int PERSONA_rut) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();

            // Se crea el objeto PreparedStatement con la consulta
            String sql = "delete from CONTACTO where PERSONA_rut = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setInt(1, PERSONA_rut);

            //Eliminando datos
            System.out.println("Eliminando datos");
            statement.executeUpdate();


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
    public void insert(int numero_celular, String correo, int numero_fijo, String linkedin,String pagina_web,String red_social, String direccion, int PERSONA_rut) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "insert into CONTACTO values (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setInt(1, numero_celular);
            statement.setString(2, correo);
            statement.setInt(3, numero_fijo);
            statement.setString(4, linkedin);
            statement.setString(5, pagina_web);
            statement.setString(6, red_social);
            statement.setString(7, direccion);
            statement.setInt(8, PERSONA_rut);

            //Ingresando contacto
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
    public void update(int numero_celular, int PERSONA_rut) {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "update CONTACTO set numero_celular = ? where PERSONA_rut = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Ingresar parametro a la consulta
            statement.setInt(1, numero_celular);
            statement.setInt(2, PERSONA_rut);

            //Actualizando contacto
            System.out.println("Actualizando contacto");
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
