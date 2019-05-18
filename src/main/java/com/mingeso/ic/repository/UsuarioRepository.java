package com.mingeso.ic.repository;

import com.mingeso.ic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario>findAll();
    List<Usuario>findUsuariosByRol(String rol);
    void delete(Usuario tipo_habitacion);
}
