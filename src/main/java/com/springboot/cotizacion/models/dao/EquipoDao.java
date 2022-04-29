package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.Equipo;
import org.springframework.data.repository.CrudRepository;

public interface EquipoDao extends CrudRepository<Equipo,Long> {

    /*
    @Query(value = "SELECT * FROM cotizacion c WHERE c. = 1",
            nativeQuery = true)
    private Cotizacion findByName(String name) { return null; }
    */
}
