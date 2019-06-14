package com.mingeso.ic.services;

import java.util.List;

import com.mingeso.ic.DAO.UsuarioDAO;
import com.mingeso.ic.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController{

	@Autowired
	UsuarioDAO usuarioDAO;

	@CrossOrigin
	@GetMapping("/usuarios")
	public List<Usuario> getUsuariosAll(){
		try{
			return usuarioDAO.getAll();
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioById(@PathVariable int id){
		try{
			return usuarioDAO.getUsuarioById(id);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@PostMapping("/usuario/insert")
	public void insertUsuario(@RequestBody Usuario user){
		try{
			usuarioDAO.insertUsuario(user);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@PostMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable int id){
		try{
			usuarioDAO.deleteUsuario(id);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
