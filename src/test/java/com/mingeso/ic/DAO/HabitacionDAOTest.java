package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Habitacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class HabitacionDAOTest {

    @Autowired
    HabitacionDAO habitacionDAO;

    @Test
    public void controlador(){
        List<Habitacion> habitacionList = habitacionDAO.getAll();
        assertNotEquals(0,habitacionList.size());
    }
}
