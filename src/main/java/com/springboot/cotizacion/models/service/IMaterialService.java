package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.Material;

import java.util.List;

public interface IMaterialService {
    public List<Material> findAll();

    public Material findById(Long id);

    public Material save(Material material);

    public void deleteById(Long id);
}
