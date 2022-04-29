package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long> {
}
