package com.mingeso.ic.services;

import java.util.List;

import com.mingeso.ic.DAO.TipoDAO;
import com.mingeso.ic.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoController{

	@Autowired
	TipoDAO tipoDAO;

	@GetMapping("/tipos")
	public List<Tipo> getTiposAll(){
		try{
			return tipoDAO.getAll();
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/tipo/{id}")
	public Tipo getTipoById(@PathVariable int id){
		try{
			return tipoDAO.getTipoById(id);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@PostMapping("/tipo/{tipo}/{valor}")
	public void insertTipo(@PathVariable String tipo, @PathVariable String valor){
		try{
			Tipo newTipo = new Tipo();
			List<Tipo> tipos = tipoDAO.getAll();
			Tipo lastTipo = tipos.get(tipos.size() - 1);
			newTipo.setId(lastTipo.getId() + 1);
			newTipo.setTipo(tipo);
			newTipo.setValor(valor);
			tipoDAO.insertTipo(newTipo);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@PostMapping("/tipo/{id}")
	public void deleteTipo(@PathVariable int id){
		try{
			tipoDAO.deleteTipo(id);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
