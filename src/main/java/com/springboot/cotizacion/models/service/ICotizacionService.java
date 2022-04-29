package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.Cotizacion;

import java.util.List;

public interface ICotizacionService {
    public List<Cotizacion> findAll();

    public Cotizacion findById(Long id);

    public Cotizacion save(Cotizacion cotizacion);

    public void deleteById(Long id);
}
