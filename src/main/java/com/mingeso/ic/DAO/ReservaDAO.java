package com.mingeso.ic.DAO;

import java.util.List;

public interface ReservaDAO {
	void insertReserva (Reserva res);
	Reserva getReservaById(int id);
	List<Reserva> getAll();
	void deleteReserva(int id);
}
