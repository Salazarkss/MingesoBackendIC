package com.mingeso.ic.repository;

import com.mingeso.ic.model.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Producto, Long> {
    List<Producto>findAll();
    //Producto findProductoById(Long id);
    Producto findProductoByCodigo(String codigo);
    List<Producto>findAllByCategoria(String categoria);
    void delete(Producto producto);
}
