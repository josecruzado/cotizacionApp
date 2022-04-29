package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.Cotizacion;
import org.springframework.data.repository.CrudRepository;


public interface CotizacionDao extends CrudRepository<Cotizacion,Long> {
    /*
    @Query(value = "SELECT * FROM cotizacion c WHERE c. = 1",
            nativeQuery = true)
    private Cotizacion findByName(String name) { return null; }
    */
}