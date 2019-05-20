package com.mingeso.ic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mingeso.ic.DAO.Habitacion;

import org.hibernate.annotations.OnDelete;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reserva")
public class Reserva {

    @Id
    @Column(name = "reserva_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habitacion_id", nullable = false)
    @JsonIgnore //En el front, se debería evitar eliminar habitaciones si existen reservas asociadas. Se puede agregar @OnDelete como alternativa
    private Habitacion habitacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_id", nullable = false)
    @JsonIgnore
    private Tipo tipo;

    //En caso de haber descuento, escribir en este campo corresponde al monto final luego de cambio de precio, otro caso NULL
    @Column(name = "valor_final")
    @JsonIgnore
    @Nullable
    private int final_descuento;

    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

    @Column(name = "inicio")
    private Date inicio;

    @Column(name = "fin")
    private Date fin;

    @Column(name = "valor")
    private int valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo_reserva() {
        return tipo;
    }

    public void setTipo_reserva(Tipo tipo_reserva) {
        this.tipo = tipo_reserva;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getFinal_descuento() {
        return final_descuento;
    }

    public void setFinal_descuento(int final_descuento) {
        this.final_descuento = final_descuento;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public int getValor() {
        return valor;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}

