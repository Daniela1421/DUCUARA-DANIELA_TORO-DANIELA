import DAO.Implements.DB;
import Modelo.Odontologo;
import Servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        DB.createTable();
        Odontologo odontologo = new Odontologo(1, "123", "Cristian", "Dominguez");
        OdontologoDAOH2 odontologoIDAO = new OdontologoDAOH2();
        OdontologoServicio odontologoServicio = new OdontologoServicio(odontologoIDAO);
        odontologoServicio.guardar(odontologo);
        odontologoServicio.listarTodos();
    }
}
