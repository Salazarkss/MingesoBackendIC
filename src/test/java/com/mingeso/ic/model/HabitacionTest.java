package com.mingeso.ic.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class HabitacionTest {
    @Test
    public void testDeHabitacion(){
        Habitacion hab = new Habitacion();
        hab.setId(123);
        assertTrue(123 == hab.getId());
        hab.setNumber("123");
        assertEquals("123", hab.getNumber());
        Tipo tipo = new Tipo();
        hab.setTipo(tipo);
        assertEquals(tipo, hab.getTipo());
    }
}
