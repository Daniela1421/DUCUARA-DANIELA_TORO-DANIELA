
package DAO.Implements;

import DAO.Implements.DB;
import DAO.Implements.IDAO;
import Modelo.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDAO<Odontologo> {

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS ("+
                    "ID, MATRICULA,NOMBRE, APELLIDO) VALUES " +
                            "(?,?,?,?)"
            );
             preparedStatement.setInt(1,odontologo.getId());
             preparedStatement.setString(2, odontologo.getMatricula());
             preparedStatement.setString(3,odontologo.getNombre());
             preparedStatement.setString(4, odontologo.getApellido());

             preparedStatement.execute();

            System.out.println("Se guardó el odontólogo con nombre " + odontologo.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String matricula = resultSet.getString("matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");

                Odontologo odontologo = new Odontologo(id, matricula, nombre, apellido);
                odontologos.add(odontologo);
                System.out.println("Estos son los odontologos que se han registrado " + odontologo.getNombre());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }
}
