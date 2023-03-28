package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IRegionDao;
import cl.bennu.labs.cv.domain.Region;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegionDao implements IRegionDao {
    @Override
    public Region get() {
        return null;
    }

    @Override
    public List<Region> find() {
        List<Region> regionList = new ArrayList<>();;
        Connection connection = null;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            // preparar la sentencia
            Statement statement = connection.createStatement();

            // ejecuto consulta
            ResultSet resultSet = statement.executeQuery("select id, nombre from REGION");
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getLong(1));
                region.setNombre(resultSet.getString(2));

                regionList.add(region);
            }
        } catch (Exception e) {
            System.out.println("error");

        } finally {
            ConnectionUtils.closeConnection(connection);
        }
        return regionList;
    }

    @Override
    public void delete(int id) {

        Connection connection = null;

        try {
            connection = ConnectionUtils.getConnection();
            PreparedStatement stat = connection.prepareStatement("delete from REGION where id=?");
            stat.setInt(1,id);
            int rowsDeleted = stat.executeUpdate();
            if (rowsDeleted > 0){
                System.out.println("Se ha borrado la región id="+id+".");
            }else{
                System.out.println("No existia región con id="+id+".");
            }

        } catch (Exception e) {
            System.out.println("error en delete");
        }finally {
            ConnectionUtils.closeConnection(connection);
        }

    }


    @Override
    public void insert(String nombre) {

        Connection connection = null;

        try {
            connection = ConnectionUtils.getConnection();
            PreparedStatement stat = connection.prepareStatement("insert into REGION (nombre) values (?)");
            stat.setString(1,nombre);
            int rowsInserted = stat.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("Se ha insertado una nueva región.");
            }

        } catch (Exception e) {
            System.out.println("error en insert");
        }finally {
            ConnectionUtils.closeConnection(connection);
        }

    }

    @Override
    public void update(int id, String nombre) {

        Connection connection = null;

        try {
            connection = ConnectionUtils.getConnection();
            PreparedStatement stat = connection.prepareStatement("update REGION set nombre=? where id=?");
            stat.setString(1,nombre);
            stat.setInt(2,id);
            int rowsUpdated = stat.executeUpdate();
            if (rowsUpdated > 0){
                System.out.println("Se ha modificado la región id="+id+".");
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
