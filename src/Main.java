import DAO.Implements.DB;
import DAO.Implements.IDAO;
import DAO.Implements.OdontologoDAOImplemMemory;
import Modelo.Odontologo;
import Servicio.OdontologoServicio;
import java.util.List;

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

        IDAO<Odontologo> odontologoDao = new OdontologoDAOImplemMemory();

        Odontologo odontologo1 = new Odontologo(1, "001", "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(2, "002", "Ana", "Gómez");

        odontologoDao.guardar(odontologo1);
        odontologoDao.guardar(odontologo2);

        Odontologo encontrado = odontologoDao.buscarPorId(1);
        System.out.println("Odontólogo encontrado: " + encontrado.getNombre() + " " + encontrado.getApellido());

        List<Odontologo> todos = ((OdontologoDAOImplemMemory)odontologoDao).listarTodos();
        todos.forEach(o -> System.out.println(o.getNombre() + " " + o.getApellido()));
    }
}
