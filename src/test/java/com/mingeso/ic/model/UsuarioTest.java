package com.mingeso.ic.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {
    @Test
    public void usuario(){
        Usuario user = new Usuario();

        user.setId(123);
        assertTrue(123==user.getId());

        user.setPassword("Contrasena");
        assertEquals("Contrasena", user.getPassword());

        user.setRol("Rol");
        assertEquals("Rol", user.getRol());

        user.setUsuario("Usuario");
        assertEquals("Usuario", user.getUsuario());
    }
}
