package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.LineaManoObra;

import java.util.List;

public interface ILineaManoObraService {
    public List<LineaManoObra> findAll();

    public LineaManoObra findById(Long id);

    public LineaManoObra save(LineaManoObra lineaManoObra);

    public void deleteById(Long id);
}
