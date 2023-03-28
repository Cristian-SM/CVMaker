package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IHabilidadDao;
import cl.bennu.labs.cv.domain.Habilidad;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDao implements IHabilidadDao {
    Connection connection = null;
    @Override
    public Habilidad get(int id){
        Habilidad hab = new Habilidad();
        try{
            connection = ConnectionUtils.getConnection();
            String query = "select h.id, h.nombre, ch.id, ch.nombre, ch.descripcion from HABILIDAD h join CATEGORIA_HABILIDAD ch on h.CATEGORIA_HABILIDAD_id = ch.id where h.id ="+id;

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                hab.setId(rs.getInt(1));
                hab.setNombre(rs.getString(2));
                hab.setCategoria_id(rs.getInt(3));
                hab.setNombre_categoria(rs.getString(4));
                hab.setDesc_categoria(rs.getString(5));
            }else{
                System.err.println("No se encontró el ID de Habilidad ingresado.");
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
        return hab;
    }

    @Override
    public List<Habilidad> find(){
        List<Habilidad> habList = new ArrayList<>();
        try{
            connection = ConnectionUtils.getConnection();
            String query = "select h.id, h.nombre, ch.id, ch.nombre, ch.descripcion from HABILIDAD h join CATEGORIA_HABILIDAD ch on h.CATEGORIA_HABILIDAD_id = ch.id";

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                Habilidad hab = new Habilidad();
                hab.setId(rs.getInt(1));
                hab.setNombre(rs.getString(2));
                hab.setCategoria_id(rs.getInt(3));
                hab.setNombre_categoria(rs.getString(4));
                hab.setDesc_categoria(rs.getString(5));

                habList.add(hab);
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
        return habList;
    }
    @Override
    public void insertHab(String nombre, int categoria_id){
        // Se define una variable que se utilizará para preparar una sentencia
        PreparedStatement insertStr;
        try{
            connection = ConnectionUtils.getConnection();

            insertStr = connection.prepareStatement("insert into HABILIDAD(nombre, CATEGORIA_HABILIDAD_id) values(?,?)");
            insertStr.setObject(1, nombre);
            insertStr.setObject(2, categoria_id);

            insertStr.execute();
            System.out.println("Habilidad registrada con éxito!!");
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
    public void deleteHab(int id) {
        try {
            connection = ConnectionUtils.getConnection();

            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from HABILIDAD where id = "+id);

            System.out.println("Borrado con éxito!!");
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
    public void insertCat() {

    }
    @Override
    public void deleteCat() {

    }
    @Override
    public void updateHab(String nombre, int categoria_id, int id) {
        PreparedStatement updateStr;
        try{
            connection = ConnectionUtils.getConnection();

            updateStr = connection.prepareStatement("update HABILIDAD set nombre = ?, CATEGORIA_HABILIDAD_id = ? where id = ?");
            updateStr.setObject(1, nombre);
            updateStr.setObject(2, categoria_id);
            updateStr.setObject(3, id);

            updateStr.execute();
            System.out.println("Habilidad actualizada con éxito!!");
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
    public void updateCat() {

    }
}
