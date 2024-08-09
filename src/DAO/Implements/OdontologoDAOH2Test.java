package DAO.Implements;

import Modelo.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoDAOH2Test {
    @Test
    public void testListarTodos() {
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

        odontologoDAOH2.guardar(new Odontologo(15454, "123", "Cristian", "Dominguez"));
        odontologoDAOH2.guardar(new Odontologo(5653565, "456", "Ana", "Gómez"));

        List<Odontologo> odontologos = odontologoDAOH2.listarTodos();
        assertEquals(2, odontologos.size());
    }
}