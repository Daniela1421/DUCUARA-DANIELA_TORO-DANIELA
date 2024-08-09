package DAO.Implements;
import Modelo.Odontologo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OdontologoDAOImplMemory implements IDAO<Odontologo> {
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Optional<Odontologo> odontologo = odontologos.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
        return odontologo.orElse(null);
    }

    public List<Odontologo> listarTodos() {
        return new ArrayList<>(odontologos);
    }
}