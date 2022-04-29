package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LineaOtros implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private float utilidad;

    @Column(nullable = false)
    private float margenUtilidad;

    @OneToOne
    private Otro otro;

    public LineaOtros(int cantidad, float utilidad, float margenUtilidad, Otro otro) {
        this.cantidad = cantidad;
        this.utilidad = utilidad;
        this.margenUtilidad = margenUtilidad;
        this.otro = otro;
    }

    public LineaOtros() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(float utilidad) {
        this.utilidad = utilidad;
    }

    public float getMargenUtilidad() {
        return margenUtilidad;
    }

    public void setMargenUtilidad(float margenUtilidad) {
        this.margenUtilidad = margenUtilidad;
    }

    public Otro getOtro() {
        return otro;
    }

    public void setOtro(Otro otro) {
        this.otro = otro;
    }
}
