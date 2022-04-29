package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.LineaMaterialesDao;
import com.springboot.cotizacion.models.entity.LineaMateriales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineaMaterialesServiceImpl implements ILineaMaterialesService{
    @Autowired
    private LineaMaterialesDao lineaMaterialesDao;

    @Override
    @Transactional(readOnly = true)
    public List<LineaMateriales> findAll() {
        return (List<LineaMateriales>) lineaMaterialesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LineaMateriales findById(Long id) {
        return lineaMaterialesDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LineaMateriales save(LineaMateriales equipo) {
        return lineaMaterialesDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        lineaMaterialesDao.deleteById(id);
    }
}
