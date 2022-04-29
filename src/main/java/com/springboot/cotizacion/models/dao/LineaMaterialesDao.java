package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.LineaMateriales;
import org.springframework.data.repository.CrudRepository;

public interface LineaMaterialesDao extends CrudRepository<LineaMateriales,Long> {
}
