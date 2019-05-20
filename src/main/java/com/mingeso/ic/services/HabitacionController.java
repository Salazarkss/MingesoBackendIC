package com.mingeso.ic.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/habitacion/{number}/{tipo}")
	public void insertHabitacion(@PathVariable String number, @PathVariable String tipo){
		System.out.println(number);
		System.out.println(tipo);
		Habitacion hab = new Habitacion();
		List<Habitacion> habitaciones = habitacionDAO.getAll();
		Habitacion lastHabitacion = habitaciones.get(habitaciones.size() - 1);
		hab.setId(lastHabitacion.getId() + 1);
		hab.setNumber(number);
		hab.setTipo(tipo);
		habitacionDAO.insertHabitacion(hab);
	}

}