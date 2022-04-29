package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.Equipo;

import java.util.List;

public interface IEquipoService {
    public List<Equipo> findAll();

    public Equipo findById(Long id);

    public Equipo save(Equipo equipo);

    public void deleteById(Long id);
}
