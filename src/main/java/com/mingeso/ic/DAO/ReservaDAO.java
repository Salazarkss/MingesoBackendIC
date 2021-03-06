package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Reserva;

import java.util.List;

public interface ReservaDAO {
	void insertReserva (Reserva res);
	Reserva getReservaById(int id);
	List<Reserva> getAll();
	List<Reserva> getReservasByCode(String codigo);
	List<Reserva> getReservasByName(String nombre);
	void deleteReserva(int id);
	void updateReserva(Reserva res);
}
