package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.OtroDao;
import com.springboot.cotizacion.models.entity.Otro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OtroServiceImpl implements IOtroService {
    @Autowired
    private OtroDao otroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Otro> findAll() {
        return (List<Otro>) otroDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Otro findById(Long id) {
        return otroDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Otro save(Otro otro) {
        return otroDao.save(otro);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        otroDao.deleteById(id);
    }
}
