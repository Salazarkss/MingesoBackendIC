package com.mingeso.ic.DAO;

import java.util.List;

public interface UsuarioDAO {
	void insertUsuario (Usuario user);
	Usuario getUsuarioById(int id);
	List<Usuario> getAll();
	void deleteUsuario(int id);
}
