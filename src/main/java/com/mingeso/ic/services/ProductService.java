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
    
    
    @RequestMapping(value = "/productoes", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://165.22.249.5:8080")
    public List<Producto> TodosLosProductos(){
        System.out.println("productos all");
        return this.productRepository.findAll();
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "productoes/categoria/{category}")
    @ResponseBody
    public List<Producto> productosCategoria(@PathVariable final String category){
        System.out.println("productos categoria");
        return this.productRepository.findAllByCategoria(category);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/productos/nuevo")
    @ResponseBody
    public Producto nuevoProducto(@RequestBody Producto product){
        System.out.println("productos nuevo");
        Producto nuevo = this.productRepository.save(product);
        System.out.println("Producto agregado con éxito");
        return nuevo;
    }

    //En vez de retornar void puede ser un http status
    @RequestMapping(method = RequestMethod.DELETE, value = "/productos/{codigo}/delete")
    @ResponseBody
    public void eliminarProducto(@PathVariable final String codigo){
        System.out.println("productos delete");
        Producto productoRepo = this.productRepository.findProductoByCodigo(codigo);
        this.productRepository.delete(productoRepo);
        System.out.println("Producto eliminado con éxito");
    }

    //Puede recibir el {id}, buscarlo en el repo y guardarlo, pero me parece que tambien se puede asi
    @RequestMapping(method = RequestMethod.POST, value = "/productos/editar")
    @ResponseBody
    public Producto editarProducto(@RequestBody Producto producto){
        System.out.println("productos edit");
        Producto editado = this.productRepository.save(producto);
        System.out.println("Producto editado con éxito");
        return editado;
    }

    /* No se pide
    @RequestMapping(method = RequestMethod.GET, value = "/mostrar/{codigo}")
    @ResponseBody
    public Producto MostrarProducto(@PathVariable("codigo") String codigo){
        System.out.println("producto id");
        return this.productRepository.findProductoByCodigo(id);
    }*/


}
