package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UsuarioDAOTest {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Test
    public void controlador(){
        List<Usuario> usuarios = usuarioDAO.getAll();
        assertNotEquals(0, usuarios.size());
    }
}
