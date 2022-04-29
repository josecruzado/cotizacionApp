package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.LineaEquiposDao;
import com.springboot.cotizacion.models.entity.LineaEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineaEquiposServiceImpl implements ILineaEquiposService{

    @Autowired
    private LineaEquiposDao lineaEquiposDao;

    @Override
    @Transactional(readOnly = true)
    public List<LineaEquipos> findAll() {
        return (List<LineaEquipos>) lineaEquiposDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LineaEquipos findById(Long id) {
        return lineaEquiposDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LineaEquipos save(LineaEquipos equipo) {
        return lineaEquiposDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        lineaEquiposDao.deleteById(id);
    }
}
