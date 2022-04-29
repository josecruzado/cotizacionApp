package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.LineaMateriales;

import java.util.List;

public interface ILineaMaterialesService {
    public List<LineaMateriales> findAll();

    public LineaMateriales findById(Long id);

    public LineaMateriales save(LineaMateriales lineaMateriales);

    public void deleteById(Long id);
}
