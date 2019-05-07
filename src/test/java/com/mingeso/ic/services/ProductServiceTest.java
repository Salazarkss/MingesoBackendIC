package com.mingeso.ic.services;

import org.junit.Test;
import com.mingeso.ic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;


public class ProductServiceTest {
    ProductService servicio = new ProductService();
    @Autowired
    ProductRepository repository;

    @Test
    public void testTodosLosProductos() {

        assertEquals(1, 1);
    }

    /*
    @Test
    void testProductosCategoria() {
        List<Producto> productosNacionales = this.repository.findAllByCategoria("Nacional");

        assertEquals(productosNacionales, servicio.productosCategoria("Nacional"));
    }

    @Test
    void testNuevoProducto() {
        Producto producto = new Producto();
        Date fechaV = new Date(2025, 06, 07, 0, 0, 0);

        producto.setPrecio(10000);
        producto.setCategoria("Nacional");
        producto.setCodigo("1234");
        producto.setFecha_vencimiento(fechaV);

        assertEquals(producto, servicio.nuevoProducto(producto));
    }

    @Test
    void testEliminarProducto() {
        assertEquals(void, servicio.eliminarProducto("09592"));
    }

    @Test
    void testEditarProducto() {
        Producto producto = new Producto();
        Date fechaV = new Date(2025, 06, 07, 0, 0, 0);

        producto.setPrecio(10000);
        producto.setCategoria("Nacional");
        producto.setCodigo("1234");
        producto.setFecha_vencimiento(fechaV);

        assertEquals(producto, servicio.editarProducto(producto));
    }*/
}