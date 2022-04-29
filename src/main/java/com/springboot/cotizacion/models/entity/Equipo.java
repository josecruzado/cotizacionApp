package com.springboot.cotizacion.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nombre;

    //RADIO,RED,SWITCHES,BATERIA,ELECTRICOS,PANELES,CAMARAS,ANTENAS
    private String categoria;

    //NRO DE MODELO
    private String modelo;

    //VOLTAJE,TAMAÑO=24RU ETC, MEDIDAS
    private String capacidad;

    private String marca;

    @Column(unique = false,nullable = false)
    private float precioCosto;

    @Column(unique = false,nullable = false)
    private float precioVenta;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String tipo) {
        this.categoria = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
