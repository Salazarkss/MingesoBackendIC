package com.mingeso.ic.DAO;

import java.util.List;

public interface HabitacionDAO {
	void insertHabitacion (Habitacion hab);
	Habitacion getHabitacionById(int id);
	List<Habitacion> getAll();
	void deleteHabitacion(int id);
}
