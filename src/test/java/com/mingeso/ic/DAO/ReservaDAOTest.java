package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Reserva;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReservaDAOTest {

    @Autowired
    ReservaDAO reservaDAO;

    @Test
    public void controlador(){
        List<Reserva> reservas = reservaDAO.getAll();
        assertNotEquals(0, reservas.size());
    }
}
