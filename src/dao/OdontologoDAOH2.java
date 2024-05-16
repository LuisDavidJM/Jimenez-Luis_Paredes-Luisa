package dao;
import org.apache.log4j.Logger;
import model.Domicilio;
import model.Odontologo;
import model.Odontologo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM odontologos";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("inicando la operacion de guardado de odontologo");
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs= psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }


        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;

        try {
            connection = BD.getConnection();
            // Preparar la consulta SQL
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Recorrer el ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                Integer matricula = resultSet.getInt("MATRICULA");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");

                Odontologo odontologo = new Odontologo( id,matricula, nombre, apellido);
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

        return odontologos;
    }
}
