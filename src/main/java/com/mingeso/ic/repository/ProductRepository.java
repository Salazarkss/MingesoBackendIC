package com.mingeso.ic.repository;

import com.mingeso.ic.model.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Component
public interface ProductRepository extends PagingAndSortingRepository<Producto, Long> {
    List<Producto>findAll();
    Producto findProductoById(Long id);
    List<Producto>findAllByCategoria(String categoria);
    void delete(Producto producto);
}
