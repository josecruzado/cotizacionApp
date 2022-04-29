package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.LineaManoObraDao;
import com.springboot.cotizacion.models.entity.LineaManoObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineaManoObraServiceImpl implements ILineaManoObraService{
    @Autowired
    private LineaManoObraDao lineaManoObraDao;

    @Override
    @Transactional(readOnly = true)
    public List<LineaManoObra> findAll() {
        return (List<LineaManoObra>) lineaManoObraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public LineaManoObra findById(Long id) {
        return lineaManoObraDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LineaManoObra save(LineaManoObra equipo) {
        return lineaManoObraDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        lineaManoObraDao.deleteById(id);
    }
}
