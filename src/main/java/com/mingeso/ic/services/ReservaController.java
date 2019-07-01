package com.mingeso.ic.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import com.mingeso.ic.DAO.ReservaDAO;
import com.mingeso.ic.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

	@PutMapping("/reservaUpdate/{id}")
	public void updateHabitacion(@PathVariable int id, @RequestBody Reserva actual){
		try{
			Reserva res = reservaDAO.getReservaById(id);
			res.setCodigo(actual.getCodigo());
			res.setFecha_reserva(actual.getFecha_reserva());
			res.setFin(actual.getFin());
			res.setFinal_descuento(actual.getFinal_descuento());
			res.setHabitacion(actual.getHabitacion());
			res.setInicio(actual.getInicio());
			res.setNombre(actual.getNombre());
			res.setTipo_Reserva(actual.getTipo_Reserva());
			res.setValor(actual.getValor());
			reservaDAO.updateReserva(res);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
