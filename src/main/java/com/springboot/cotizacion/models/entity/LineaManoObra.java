package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LineaManoObra implements Serializable{

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
    private ManoDeObra manoDeObra;

    public LineaManoObra(int cantidad, float utilidad, float margenUtilidad, ManoDeObra manoDeObra) {
        this.cantidad = cantidad;
        this.utilidad = utilidad;
        this.margenUtilidad = margenUtilidad;
        this.manoDeObra = manoDeObra;
    }

    public LineaManoObra() {
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

    public ManoDeObra getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(ManoDeObra manoDeObra) {
        this.manoDeObra = manoDeObra;
    }
}