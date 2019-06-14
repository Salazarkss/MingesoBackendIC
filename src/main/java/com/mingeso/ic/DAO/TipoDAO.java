package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Tipo;

import java.util.List;

public interface TipoDAO {
	void insertTipo (Tipo tipo);
	Tipo getTipoById(int id);
	List<Tipo> getAll();
	void deleteTipo(int id);
}
