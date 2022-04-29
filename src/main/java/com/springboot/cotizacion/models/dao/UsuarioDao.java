package com.springboot.cotizacion.models.dao;

import com.springboot.cotizacion.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
