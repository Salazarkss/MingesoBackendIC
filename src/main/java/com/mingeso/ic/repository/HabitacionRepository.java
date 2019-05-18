package com.mingeso.ic.repository;

import com.mingeso.ic.model.Habitacion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HabitacionRepository extends PagingAndSortingRepository<Habitacion, Long> {
    List<Habitacion>findAll();
    List<Habitacion>findHabitacionsByTipo(String type);
    List<Habitacion> findHabitacionByNumber(String Number);
    void delete(Habitacion habitacion);
}
