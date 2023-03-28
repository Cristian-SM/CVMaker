package cl.bennu.labs.cv.dao.impl.jdbc;

import cl.bennu.labs.cv.dao.iface.IPersonaDao;
import cl.bennu.labs.cv.domain.Persona;
import cl.bennu.labs.cv.jdbc.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao implements IPersonaDao {

    Connection connection = null;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public Persona get(Long rut){
        Persona persona = new Persona();
        try {
            connection = ConnectionUtils.getConnection();
            String sql = "select * from PERSONA where rut = ?";
            pst = connection.prepareStatement(sql);
            pst.setLong(1, rut);
            rs = pst.executeQuery();
            while(rs.next()){

                if(rs.getLong(1) == rut) {
                    setRs(rs, persona);
                    //System.out.println("Se encontro el rut");
                    return persona;
                }
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
            return persona;
        }
    }
    @Override
    public List<Persona> find(){
        List<Persona> personaList = new ArrayList<>();;
        try {
            // traer conexion
            connection = ConnectionUtils.getConnection();

            String sql = "select * from PERSONA;";

            // preparar la sentencia
            Statement statement = connection.createStatement();

            // ejecuto consulta
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                setRs(rs, persona);
                personaList.add(persona);
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
        return personaList;
    }

    private void setRs(ResultSet rs, Persona persona) throws SQLException {
        persona.setRut(rs.getLong(1));
        persona.setDv(rs.getString(2).charAt(0));
        persona.setNombreCompleto(rs.getString(3));
        persona.setFechaNacimiento(rs.getString(4));
        persona.setFoto(rs.getBlob(5));
        persona.setEstadoCivil(rs.getInt(6));
        persona.setSexo(rs.getInt(7));
        persona.setNacionalidad(rs.getInt(8));
        persona.setComuna(rs.getInt(9));
    }

    private void setPst(PreparedStatement pst, Persona persona) throws SQLException {
        pst.setLong(1, persona.getRut());
        pst.setString(2, String.valueOf(persona.getDv()));
        pst.setString(3, persona.getNombreCompleto());
        pst.setString(4, persona.getFechaNacimiento());
        pst.setBlob(5, persona.getFoto());
        pst.setInt(6, persona.getEstadoCivil());
        pst.setInt(7, persona.getSexo());
        pst.setInt(8, persona.getNacionalidad());
        pst.setInt(9, persona.getComuna());
    }

    @Override
    public void delete(Long rut){
        String sql = "delete from PERSONA where rut = ?";
        try{
            connection = ConnectionUtils.getConnection();
            pst = connection.prepareStatement(sql);
            pst.setLong(1, rut);
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
    public void insert(Persona persona){
        String sql = "insert into PERSONA(rut, dv, nombre_completo, fecha_nacimiento, foto, ESTADO_CIVIL_id, SEXO_id, NACIONALIDAD_id, COMUNA_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            connection = ConnectionUtils.getConnection();
            pst = connection.prepareStatement(sql);
            setPst(pst, persona);
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
    public void update(Long rut, String value) {
        String sql = "update PERSONA set nombre_completo = ? where rut = ?";
        try {
            connection = ConnectionUtils.getConnection();
            pst = connection.prepareStatement(sql);
            pst.setLong(2, rut);
            pst.setString(1, value);
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
