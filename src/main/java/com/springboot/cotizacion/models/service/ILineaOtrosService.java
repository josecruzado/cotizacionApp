package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.LineaOtros;

import java.util.List;

public interface ILineaOtrosService{
    public List<LineaOtros> findAll();

    public LineaOtros findById(Long id);

    public LineaOtros save(LineaOtros lineaOtros);

    public void deleteById(Long id);
}
