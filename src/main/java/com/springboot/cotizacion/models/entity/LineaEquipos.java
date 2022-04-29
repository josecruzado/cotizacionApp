package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lineaEquipos")
public class LineaEquipos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = true)
    private float utilidad;

    @Column(nullable = false)
    private float margenUtilidad;

    @OneToOne
    private Equipo equipo;

    public LineaEquipos(int cantidad, float utilidad, float margenUtilidad, Equipo equipo) {
        this.cantidad = cantidad;
        this.utilidad = utilidad;
        this.margenUtilidad = margenUtilidad;
        this.equipo = equipo;
    }

    public LineaEquipos() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(float utilidad) {
        this.utilidad = utilidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getMargenUtilidad() {
        return margenUtilidad;
    }

    public void setMargenUtilidad(float margenUtilidad) {
        this.margenUtilidad = margenUtilidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
