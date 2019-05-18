package com.mingeso.ic.repository;

import com.mingeso.ic.model.Reserva;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends PagingAndSortingRepository<Reserva, Long> {
    List<Reserva>findAll();
    List<Reserva>findReservasByInicioBetween(Date inicio, Date fin);
    List<Reserva> findReservasByInicioBetweenAndAndCodigo(Date inicio, Date fin, String codigo);
    List<Reserva> findReservasByInicioBetweenAndAndNombre(Date inicio, Date fin, String nombre);
    List<Reserva> findReservasByNombre(String nombre);
    void delete(Reserva reserva);
}
