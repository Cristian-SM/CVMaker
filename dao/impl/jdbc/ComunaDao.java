package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IComunaDao;
import cl.bennu.labs.cv.domain.Comuna;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComunaDao implements IComunaDao {

    Connection connection = null;
    String sql;
    List<Comuna> comunaList = new ArrayList<>();
    @Override
    public Comuna get() {return null;}

    @Override
    public List<Comuna> find() {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();
            sql = "select id, nombre, REGION_id from COMUNA";
            // preparar la sentencia
            Statement statement = connection.createStatement();
            // ejecuto consulta
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Comuna comuna = new Comuna();
                comuna.setId(resultSet.getLong(1));
                comuna.setNombre(resultSet.getString(2));
                comuna.setREGION_id(resultSet.getLong(3));
                comunaList.add(comuna);
            }
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return comunaList;
    }
    @Override
    public List<Comuna> findByRegion(int REGION_id) {
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();
            // preparar la sentencia
            sql = "select c.id, c.nombre, c.REGION_id, r.nombre from COMUNA c join REGION r on c.REGION_id=r.id where c.REGION_id=?";
            // ejecuto consulta
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setInt(1,REGION_id);
            ResultSet resultSet = stat.executeQuery();
            while (resultSet.next()) {
                Comuna comuna = new Comuna();
                comuna.setId(resultSet.getLong(1));
                comuna.setNombre(resultSet.getString(2));
                comuna.setREGION_id(resultSet.getLong(3));
                comuna.setREGION_nombre(resultSet.getString(4));
                comunaList.add(comuna);
            }
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return comunaList;
    }

    @Override
    public void delete(int id){
        try {
            connection = ConnectionUtils.getConnection();
            sql="delete from COMUNA where id=?";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setInt(1,id);
            int rowsDeleted = stat.executeUpdate();
            if (rowsDeleted > 0){
                System.out.println("Se ha borrado la comuna de id="+id+".");
            }else{
                System.out.println("No existia comuna con id="+id+".");
            }
        } catch (Exception e) {
            System.out.println("error en delete");
        }finally {
            ConnectionUtils.closeConnection(connection);
        }
    }
    @Override
    public void insert(String nombre, int REGION_id){
        try {
            connection = ConnectionUtils.getConnection();
            sql = "insert into COMUNA (nombre, REGION_id) values (?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,nombre);
            stat.setInt(2,REGION_id);
            int rowsInserted = stat.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Se ha insertado una nueva comuna.");
            }else{
                System.out.println("No se pudo insertar nueva comuna");
            }
        } catch (Exception e) {
            System.out.println("error en insert");
        }finally {
            ConnectionUtils.closeConnection(connection);
        }
    }
    @Override
    public void update(int id, String nombre){
        try {
            connection = ConnectionUtils.getConnection();
            PreparedStatement stat = connection.prepareStatement("update COMUNA set nombre=? where id=?");
            stat.setString(1,nombre);
            stat.setInt(2,id);
            int rowsUpdated = stat.executeUpdate();
            if (rowsUpdated > 0){
                System.out.println("Se ha modificado la comuna id="+id+".");
            }else{
                System.out.println("El id a modificar no existia.");
            }
        } catch (Exception e) {
            System.out.println("error en insert");
        }finally {
            ConnectionUtils.closeConnection(connection);
        }

    }
}
