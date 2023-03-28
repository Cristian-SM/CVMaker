package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IExpLaboralDao;
import cl.bennu.labs.cv.domain.ExpLaboral;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpLaboralDao implements IExpLaboralDao {

    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    Connection connection = null;
    @Override
    public ExpLaboral get(int id){
        ExpLaboral exp = new ExpLaboral();

        try{
            connection = ConnectionUtils.getConnection();

            String query = "select * from EXP_LABORAL where id = "+id;

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                definir(exp, rs);
                return exp;
            }else{
                return null;
            }
        } catch (SQLNonTransientConnectionException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Tiempo de espera agotado para la operación: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la consulta SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fallo de conexion" + e.getMessage());
            return null;
        } finally {
            ConnectionUtils.closeConnection(connection);
            return exp;
        }
    }

    private void definir(ExpLaboral exp, ResultSet rs) throws SQLException {
        exp.setId(rs.getInt(1));
        exp.setEmpresa(rs.getString(2));
        exp.setArea(rs.getString(3));
        exp.setCargo(rs.getString(4));
        exp.setDescripcion(rs.getString(5));
        exp.setFecha_inicio(rs.getString(6));
        exp.setFecha_termino(rs.getString(7));
        exp.setCurriculum_id(rs.getInt(8));
    }
    private void modificarPreparedStr(String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id, PreparedStatement insertStr) throws SQLException {
        insertStr.setObject(1, empresa);
        insertStr.setObject(2, area);
        insertStr.setObject(3, cargo);
        insertStr.setObject(4, descripcion);
        insertStr.setObject(5, fecha_inicio);
        insertStr.setObject(6, fecha_termino);
        insertStr.setObject(7, curriculum_id);
    }
    @Override
    public List<ExpLaboral> find(int id) {
        List<ExpLaboral> ExpLabList = new ArrayList<>();
        try{
            connection = ConnectionUtils.getConnection();

            String query = "select * from EXP_LABORAL WHERE CURRICULUM_id = ?";

            // preparar la sentencia
            pst = connection.prepareStatement(query);

            pst.setInt(1,id);

            rs = pst.executeQuery();

            while(rs.next()){
                ExpLaboral explab = new ExpLaboral();
                definir(explab, rs);
                ExpLabList.add(explab);
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
        return ExpLabList;
    }
    @Override
    public void delete(int id){
        try {
            connection = ConnectionUtils.getConnection();

            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from EXP_LABORAL where id = "+id);

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
    public void insert(String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id){
        PreparedStatement insertStr;
        try {
            connection = ConnectionUtils.getConnection();

            insertStr = connection.prepareStatement("insert into EXP_LABORAL(empresa, area, cargo, descripcion, fecha_inicio, fecha_fin, CURRICULUM_id) values (?,?,?,?,?,?,?)");

            modificarPreparedStr(empresa, area, cargo, descripcion, fecha_inicio, fecha_termino, curriculum_id, insertStr);

            insertStr.execute();

            System.out.println("Registrado con éxito!!");
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
    public void update(String empresa, String area, String cargo, String descripcion, String fecha_inicio, String fecha_termino, int curriculum_id, int id){
        PreparedStatement updateStr;
        try{
            connection = ConnectionUtils.getConnection();

            updateStr = connection.prepareStatement("update EXP_LABORAL set empresa = ?, area = ?, cargo = ?, descripcion = ?, fecha_inicio = ?, fecha_fin = ?, CURRICULUM_id = ? where id = ?");

            // Asignando variables al preparedStatement para ser ejecutado (las variables reemplazan a los "?")
            modificarPreparedStr(empresa, area, cargo, descripcion, fecha_inicio, fecha_termino, curriculum_id, updateStr);
            updateStr.setObject(8, id);

            updateStr.execute();

            System.out.println("Actualizado con éxito!!");
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
