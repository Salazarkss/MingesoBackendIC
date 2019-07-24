/*package com.mingeso.ic.services;

import com.mingeso.ic.DAO.ReservaDAO;
import com.mingeso.ic.model.Reserva;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ReservaControllerTest {

    @InjectMocks
    ReservaController reservaController = new ReservaController();

    @Mock
    ReservaDAO reservaDAO;

    @Test
    public void testController(){
        List<Reserva> reservas = reservaController.getReservasAll();

        assertNotNull(reservas);
        assertTrue(reservas.size()>0);
        Reserva reserva = reservas.get(0);
        assertNotNull(reserva);
    }
}

*/