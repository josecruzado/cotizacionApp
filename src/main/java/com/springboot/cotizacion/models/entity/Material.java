package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Material implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nombre;

    //Cable cat6, cajas, tubos, pernos, tarugos, jack, curvas, cintas, abrazaderas, patch cord
    private String categoria;

    // de 3/4", cat6, 1/2" rollo x100 mts
    private String capacidad;

    @Column(unique = false,nullable = false)
    private float precioCosto;

    @Column(unique = false,nullable = false)
    private float precioVenta;

    public Material(String nombre, String categoria, String capacidad, float precioCosto, float precioVenta) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
    }

    public Material() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
}
