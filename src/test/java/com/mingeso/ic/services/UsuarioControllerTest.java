/*package com.mingeso.ic.services;

import com.mingeso.ic.DAO.UsuarioDAO;
import com.mingeso.ic.model.Usuario;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController = new UsuarioController();

    @Mock
    private UsuarioDAO dao;

    @Test
    public void testController(){
        List<Usuario> usuarios = usuarioController.getUsuariosAll();

        assertNotNull(usuarios);
        assertTrue(usuarios.size()>0);

        Usuario usuario = usuarios.get(0);
        assertNotNull(usuario);
    }
}
*/