package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Habitacion;

import java.util.List;

public interface HabitacionDAO {
	void insertHabitacion (Habitacion hab);
	Habitacion getHabitacionById(int id);
	List<Habitacion> getAll();
	void updateHabitacion(Habitacion hab);
	void updateDisponibilidad(Habitacion hab);
	void deleteHabitacion(int id);
}
