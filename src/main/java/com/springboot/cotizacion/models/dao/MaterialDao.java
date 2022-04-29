package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialDao extends CrudRepository<Material,Long> {
    /*
    @Query(value = "SELECT * FROM cotizacion c WHERE c. = 1",
            nativeQuery = true)
    private Cotizacion findByName(String name) { return null; }
    */
}
