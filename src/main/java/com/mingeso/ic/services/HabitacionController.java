package com.mingeso.ic.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitacionController{

	@Autowired
	HabitacionDAO habitacionDAO;

	@Autowired
	TipoDAO tipoDAO;

	@GetMapping("/habitaciones")
	public List<Habitacion> getHabitacionesAll(){
		try{
			return habitacionDAO.getAll();
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/habitacion/{id}")
	public Habitacion getHabitacionById(@PathVariable int id){
		try{
			return habitacionDAO.getHabitacionById(id);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	@CrossOrigin
	@PostMapping("/habitacion/{number}/{tipo}")
	public void insertHabitacion(@PathVariable String number, @PathVariable int tipo){
		try{
			Habitacion hab = new Habitacion();
			List<Habitacion> habitaciones = habitacionDAO.getAll();
			Habitacion lastHabitacion = habitaciones.get(habitaciones.size() - 1);
			hab.setId(lastHabitacion.getId() + 1);
			hab.setNumber(number);
			hab.setTipo(tipoDAO.getTipoById(tipo));
			habitacionDAO.insertHabitacion(hab);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@PostMapping("/habitacion/{id}")
	public void deleteHabitacion(@PathVariable int id){
		try{
			habitacionDAO.deleteHabitacion(id);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@PutMapping("/habitacion/{id}")
	public void updateHabitacion(@PathVariable int id, @RequestBody Tipo tipo){
		try{
			Habitacion hab = habitacionDAO.getHabitacionById(id);
			hab.setTipo(tipo);
			habitacionDAO.updateHabitacion(hab);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
