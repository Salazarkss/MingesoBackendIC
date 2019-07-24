/*package com.mingeso.ic.services;

import com.mingeso.ic.DAO.TipoDAO;
import com.mingeso.ic.model.Tipo;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TipoControllerTest {

    @InjectMocks
    private TipoController tipoController = new TipoController();

    @Mock
    private TipoDAO tipoDAO;

    @Test
    public void testController(){
        List<Tipo> tipos = tipoController.getTiposAll();

        assertNotNull(tipos);
        assertTrue(tipos.size()>0);
        Tipo tipo = tipos.get(0);
        assertNotNull(tipo);
    }
}
*/