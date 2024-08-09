package DAO.Implements;

import Modelo.Odontologo;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDAOImplemMemoryTest {
    @Test
    public void testListarTodos() {
        OdontologoDAOImplemMemory odontologoDAOImplemMemory = new OdontologoDAOImplemMemory();

        odontologoDAOImplemMemory.guardar(new Odontologo(5, "123", "Cristian", "Dominguez"));
        odontologoDAOImplemMemory.guardar(new Odontologo(6, "456", "Ana", "Gómez"));

        List<Odontologo> odontologos = odontologoDAOImplemMemory.listarTodos();
        assertEquals(2, odontologos.size());
    }
}