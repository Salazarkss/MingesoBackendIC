package com.mingeso.ic.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Table(name="habitacion")
public class Habitacion {

    @Id
    @Column(name = "habitacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "tipo_reserva")
	private String tipoReserva;

    @ManyToOne
    @JoinColumn
    private Tipo tipo;
    
    public int getId() {
    	return id;
    }
    
    public void setId(int i) {
    	this.id = i;
    }
    
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", number=" + number + ", tipo=" + tipo.getId() + "]";
	}
	
	

}

