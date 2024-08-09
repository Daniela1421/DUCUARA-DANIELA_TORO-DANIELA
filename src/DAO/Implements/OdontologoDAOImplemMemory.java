package DAO.Implements;
import Modelo.Odontologo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

public class OdontologoDAOImplemMemory implements IDAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOImplemMemory.class);

    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Guardando odontólogo: " + odontologo);
        odontologos.add(odontologo);
        LOGGER.info("Odontólogo guardado exitosamente: " + odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        LOGGER.info("Buscando odontólogo con ID: " + id);
        Optional<Odontologo> odontologo = odontologos.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
        if (odontologo.isPresent()) {
            LOGGER.info("Odontólogo encontrado: " + odontologo.get());
        } else {
            LOGGER.warn("Odontólogo con ID " + id + " no encontrado.");
        }
        return odontologo.orElse(null);
    }

    public List<Odontologo> listarTodos() {
        return new ArrayList<>(odontologos);
    }
}