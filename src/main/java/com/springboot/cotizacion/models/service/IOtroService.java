package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.Otro;

import java.util.List;

public interface IOtroService {
    public List<Otro> findAll();

    public Otro findById(Long id);

    public Otro save(Otro otro);

    public void deleteById(Long id);
}
