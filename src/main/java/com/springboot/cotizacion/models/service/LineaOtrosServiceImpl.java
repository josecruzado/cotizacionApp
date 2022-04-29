package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.LineaOtrosDao;
import com.springboot.cotizacion.models.entity.LineaOtros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineaOtrosServiceImpl implements ILineaOtrosService {
    @Autowired
    private LineaOtrosDao lineaOtrosDao;

    @Override
    @Transactional(readOnly = true)
    public List<LineaOtros> findAll() {
        return (List<LineaOtros>) lineaOtrosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LineaOtros findById(Long id) {
        return lineaOtrosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LineaOtros save(LineaOtros equipo) {
        return lineaOtrosDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        lineaOtrosDao.deleteById(id);
    }
}
