package com.mingeso.ic.services;

import com.mingeso.ic.model.Producto;
import com.mingeso.ic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/productos/all")
    public List<Producto> showProducts(){
        System.out.println("productos all");
        return this.productRepository.findAll();
    }

    @GetMapping(value = "/productos/categoria/{category}")
    public List<Producto> productosCategoria(@RequestParam("categoria") String category){
        System.out.println("productos categoria");
        return this.productRepository.findAllByCategoria(category);
    }

    @PostMapping(value = "/productos/nuevo")
    public Producto nuevoProducto(@RequestBody Producto product){

        System.out.println("productos nuevo");
        Producto nuevo = this.productRepository.save(product);
        System.out.println("Producto agregado con éxito");
        return nuevo;
    }

    //En vez de retornar void puede ser un http status
    @DeleteMapping(value = "/producto/{id}/delete")
    public void eliminarProducto(@RequestParam("id") Long id){

        System.out.println("productos delete");
        Producto productoRepo = this.productRepository.findProductoById(id);
        this.productRepository.delete(productoRepo);
        System.out.println("Producto eliminado con éxito");
    }

    //Puede recibir el {id}, buscarlo en el repo y guardarlo, pero me parece que tambien se puede asi
    @PutMapping(value = "/producto/editar")
    public Producto editarProducto(@RequestBody Producto producto){
        Producto editado = this.productRepository.save(producto);
        System.out.println("Producto editado con éxito");
        return editado;
    }

}
