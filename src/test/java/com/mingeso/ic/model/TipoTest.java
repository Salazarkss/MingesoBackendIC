package com.mingeso.ic.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TipoTest {

    @Test
    public void tipo(){
        Tipo tipo = new Tipo();
        
        tipo.setId(123);
        assertTrue(123==tipo.getId());

        tipo.setTipo("Tipo");
        assertEquals("Tipo", tipo.getTipo());

        tipo.setValor("123");
        assertEquals("123", tipo.getValor());
    }
}
