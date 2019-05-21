package com.mingeso.ic.DAO;

import javax.persistence.*;

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

