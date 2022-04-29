package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.EquipoDao;
import com.springboot.cotizacion.models.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipoServiceImpl implements IEquipoService{

    @Autowired
    private EquipoDao equipoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll() {
        return (List<Equipo>) equipoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Equipo findById(Long id) {
        return equipoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Equipo save(Equipo equipo) {
        return equipoDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        equipoDao.deleteById(id);
    }
}
