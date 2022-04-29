package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.LineaEquipos;

import java.util.List;

public interface ILineaEquiposService {
    public List<LineaEquipos> findAll();

    public LineaEquipos findById(Long id);

    public LineaEquipos save(LineaEquipos lineaEquipos);

    public void deleteById(Long id);
}
