package com.mingeso.ic.DAO;

import javax.persistence.*;
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

    @Column(name = "tipo")
    private String tipo;
    
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", number=" + number + ", tipo=" + tipo + "]";
	}
	
	

}

