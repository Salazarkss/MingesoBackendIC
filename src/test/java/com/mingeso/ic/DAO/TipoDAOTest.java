package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Tipo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TipoDAOTest {

    @Autowired
    TipoDAO tipoDAO;

    @Test
    public void controlador(){
        List<Tipo> tipos = tipoDAO.getAll();
        assertNotEquals(0,tipos.size());
    }
}
