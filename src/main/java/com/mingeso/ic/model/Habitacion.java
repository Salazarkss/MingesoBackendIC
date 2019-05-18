package com.mingeso.ic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="habitacion")
public class Habitacion {

    @Id
    @Column(name = "habitacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "tipo")
    private String tipo;

}

