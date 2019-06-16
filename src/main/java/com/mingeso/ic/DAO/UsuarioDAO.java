package com.mingeso.ic.DAO;

import com.mingeso.ic.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
	void insertUsuario (Usuario user);
	Usuario getUsuarioById(int id);
	List<Usuario> getAll();
	void deleteUsuario(int id);
	String login(Usuario usuario);
}
