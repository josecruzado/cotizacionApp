package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.ManoDeObra;

import java.util.List;

public interface IManoDeObraService {
    public List<ManoDeObra> findAll();

    public ManoDeObra findById(Long id);

    public ManoDeObra save(ManoDeObra manoDeObra);

    public void deleteById(Long id);
}
