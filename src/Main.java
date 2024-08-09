import DAO.Implements.DB;
import DAO.Implements.IDAO;
import Modelo.Odontologo;
import Servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        DB.createTable();
        Odontologo odontologo = new Odontologo(1, "123", "Cristian", "Dominguez");
        OdontologoDAOH2 odontologoIDAO = new OdontologoDAOH2();
        OdontologoServicio odontologoServicio = new OdontologoServicio(odontologoIDAO);
        odontologoServicio.guardar(odontologo);

        IDAO<Odontologo> odontologoDao = new OdontologoDAOImplMemory();

        Odontologo odontologo1 = new Odontologo(1, "001", "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(2, "002", "Ana", "Gómez");

        odontologoDao.guardar(odontologo1);
        odontologoDao.guardar(odontologo2);

        Odontologo encontrado = odontologoDao.buscarPorId(1);
        System.out.println("Odontólogo encontrado: " + encontrado.getNombre() + " " + encontrado.getApellido());

        List<Odontologo> todos = ((OdontologoDAOImplMemory)odontologoDao).listarTodos();
        todos.forEach(o -> System.out.println(o.getNombre() + " " + o.getApellido()));
    }
}
