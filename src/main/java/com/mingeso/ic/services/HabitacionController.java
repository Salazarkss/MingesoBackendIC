package com.mingeso.ic.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitacionController{

	@Autowired
	HabitacionDAO habitacionDAO;

	@GetMapping("/habitaciones")
	public List<Habitacion> getHabitacionesAll(){
		return habitacionDAO.getAll();
	}

	@GetMapping("/habitacion/{id}")
	public Habitacion getHabitacionById(@PathVariable int id){
		try{
			return habitacionDAO.getHabitacionById(id);
		}
		catch(Exception e){
			return null;
		}
	}

}