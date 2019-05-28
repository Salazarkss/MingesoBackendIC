package com.mingeso.ic.DAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import bsh.ParseException;

@RestController
public class ReservaController{

	@Autowired
	ReservaDAO reservaDAO;

	@GetMapping("/reservas")
	public List<Reserva> getReservasAll(){
		try{
			return reservaDAO.getAll();
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/reserva/{id}")
	public Reserva getReservaById(@PathVariable int id){
		try{
			return reservaDAO.getReservaById(id);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/reservas/codigo/{codigo}")
	public List<Reserva> getReservasByCode(@PathVariable String codigo) {
		try{
			return reservaDAO.getReservasByCode(codigo);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	//aksljdlkajslkdak
	@GetMapping("/reservas/nombre/{nombre}")
	public List<Reserva> getReservasByName(@PathVariable String nombre) {
		try{
			return reservaDAO.getReservasByName(nombre);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}	
	}

	@PostMapping("/reserva/insert")
	public void insertReserva(@RequestBody Reserva reserva){
		try{
			reservaDAO.insertReserva(reserva);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@PostMapping("/reserva/delete/{id}")
	public void deleteReserva(@PathVariable int id){
		try{
			reservaDAO.deleteReserva(id);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}