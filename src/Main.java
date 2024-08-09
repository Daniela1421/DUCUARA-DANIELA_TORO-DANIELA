import DAO.Implements.DB;
import Modelo.Odontologo;
import Servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        DB.createTable();
        Odontologo odontologoH2 = new Odontologo(1, "123", "Cristian", "Dominguez");
        Odontologo odontologo1H2 = new Odontologo(2, "345","David", "Herrera");
        OdontologoDAOH2 odontologoIDAO = new OdontologoDAOH2();
        OdontologoServicio odontologoServicio = new OdontologoServicio(odontologoIDAO);
        odontologoServicio.guardar(odontologoH2);
        odontologoServicio.guardar(odontologo1H2);
        odontologoServicio.listarTodos();
    }
}
