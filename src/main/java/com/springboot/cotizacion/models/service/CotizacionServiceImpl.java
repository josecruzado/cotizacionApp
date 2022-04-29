package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.CotizacionDao;
import com.springboot.cotizacion.models.entity.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CotizacionServiceImpl implements ICotizacionService {
    @Autowired
    private CotizacionDao cotizacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cotizacion> findAll() {
        return (List<Cotizacion>) cotizacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cotizacion findById(Long id) {
        return (Cotizacion) cotizacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cotizacion save(Cotizacion cliente) {
        return (Cotizacion) cotizacionDao.save(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cotizacionDao.deleteById(id);
    }
}
