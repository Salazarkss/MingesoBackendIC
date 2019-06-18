package com.mingeso.ic.services;

import com.mingeso.ic.model.Habitacion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class HabitacionControllerTest {
    public HabitacionController habitacionController = new HabitacionController();

    @Test
    public void controlador(){
        List<Habitacion> habitaciones = habitacionController.getHabitacionesAll();
        assertNotNull(habitaciones);
    }
}
