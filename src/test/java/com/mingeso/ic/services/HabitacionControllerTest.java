package com.mingeso.ic.services;

import com.mingeso.ic.DAO.HabitacionDAO;
import com.mingeso.ic.DAO.TipoDAO;
import com.mingeso.ic.model.Habitacion;
import org.hibernate.service.spi.ServiceException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HabitacionControllerTest {

    @InjectMocks
    private HabitacionController habitacionController = new HabitacionController();

    @Mock
    HabitacionDAO habitacionDAO;

    @Mock
    TipoDAO tipoDAO;

    @Test
    public void testController() throws ServiceException {
        List<Habitacion> habitaciones = habitacionController.getHabitacionesAll();

        assertNotNull(habitaciones);
        assertTrue(habitaciones.size()>0);
    }
}
