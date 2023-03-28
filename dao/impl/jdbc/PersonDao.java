package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IPersonDao;
import cl.bennu.labs.cv.domain.Person;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;
import jdk.jshell.spi.ExecutionControlProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements IPersonDao {
    @Override
    public Person get() {
        Person p = null;
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "select * from USUARIO where id = 10";

            // preparar la sentencia
            Statement statement = connection.createStatement();

            // ejecuto consulta
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                p = new Person();
                p.setId(resultSet.getLong(1));
                p.setName(resultSet.getString(2));
            }
        }
        catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
            return p;
        }
    }

    @Override
    public List<Person> find() {
        List<Person> personList = new ArrayList<>();;
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "select * from USUARIO";

            // preparar la sentencia
            Statement statement = connection.createStatement();

            // ejecuto consulta
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong(1));
                person.setName(resultSet.getString(2));

                personList.add(person);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return personList;
    }

    @Override
    public void delete() {
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "DELETE FROM USUARIO WHERE id = 10";

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void insert() {
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "INSERT INTO USUARIO VALUES(10, 'Hola Mundo')";

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }

    @Override
    public void update() {
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "UPDATE USUARIO SET nombre = 'Nuevo Nombre' WHERE id = 10";

            // preparar la sentencia
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            ConnectionUtils.closeConnection(connection);
        }
    }
}