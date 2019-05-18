package com.mingeso.ic.services;

import com.mingeso.ic.model.Reserva;
import com.mingeso.ic.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    
    @CrossOrigin(origins = "http://165.22.249.5:8080")
    @ResponseBody
    public List<Reserva> TodasLasReservas(){
        System.out.println("reservas all");
        return this.reservaRepository.findAll();
    }

    @GetMapping
    @ResponseBody
    public List<Reserva> reservasIntervalo(@RequestParam(value = "inicio") String inicio, @RequestParam(value = "fin") String fin) throws ParseException {
        Date fecha_inicio = new SimpleDateFormat("dd/MM/yyyy").parse(inicio);
        Date fecha_fin = new SimpleDateFormat("dd/MM/yyyy").parse(fin);
        List<Reserva> reservas = this.reservaRepository.findReservasByInicioBetween(fecha_inicio, fecha_fin);
        return reservas;
    }


}
