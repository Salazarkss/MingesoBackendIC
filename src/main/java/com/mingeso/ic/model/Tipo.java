package com.mingeso.ic.DAO;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="tipo")
public class Tipo {

    @Id
    @Column(name = "tipo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo")
    private String tipo; //Simple, Doble, Triple, Familiar, Suite, etc

    @Column(name = "valor")
    private String valor;

    @OneToMany(orphanRemoval = true, mappedBy = "tipo", cascade = CascadeType.REMOVE)
    private Set<Habitacion> habitaciones; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}

