package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);

}
