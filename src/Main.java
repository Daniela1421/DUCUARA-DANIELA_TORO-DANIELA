import DAO.Implements.DB;
import Modelo.Odontologo;
import Servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        DB.createTable();
        Odontologo odontologo = new Odontologo(1, "123", "Cristian", "Dominguez");
        Odontologo odontologo1 = new Odontologo(2, "345","David", "Herrera");
        OdontologoDAOH2 odontologoIDAO = new OdontologoDAOH2();
        OdontologoServicio odontologoServicio = new OdontologoServicio(odontologoIDAO);
        odontologoServicio.guardar(odontologo);
        odontologoServicio.guardar(odontologo1);
        odontologoServicio.listarTodos();
    }
}
