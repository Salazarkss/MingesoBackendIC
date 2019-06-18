package com.mingeso.ic.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void reserva(){
        Reserva reserva = new Reserva();

        reserva.setCodigo("123");
        assertEquals("123", reserva.getCodigo());

        reserva.setValor(123);
        assertTrue(123 == reserva.getValor());

        reserva.setFinal_descuento(123);
        assertTrue(123 == reserva.getFinal_descuento());

        reserva.setNombre("Nombre");
        assertEquals("Nombre", reserva.getNombre());

        reserva.setId(123);
        assertTrue(123==reserva.getId());

        reserva.setTipo_Reserva("Tipo");
        assertEquals("Tipo", reserva.getTipo_Reserva());

        Date a = new Date();
        reserva.setFecha_reserva(a);
        assertEquals(a,reserva.getFecha_reserva());

        reserva.setInicio(a);
        assertEquals(a,reserva.getInicio());

        reserva.setFin(a);
        assertEquals(a,reserva.getFin());

        Habitacion habitacion = new Habitacion();
        reserva.setHabitacion(habitacion);
        assertEquals(habitacion,reserva.getHabitacion());
    }
}
