package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ManoDeObra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //tecnico, externo, ingeniero entre otros
    @Column(unique = true,nullable = false)
    private String descripcion;

    @Column(unique = false,nullable = false)
    private float precioCosto;

    @Column(unique = false,nullable = false)
    private float precioVenta;


    public ManoDeObra(String descripcion, float precioCosto, float precioVenta) {
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
    }

    public ManoDeObra() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
}
