package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.ManoDeObraDao;
import com.springboot.cotizacion.models.entity.ManoDeObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManoDeObraServiceImpl implements IManoDeObraService{
    @Autowired
    private ManoDeObraDao manoDeObraDao;

    @Override
    @Transactional(readOnly = true)
    public List<ManoDeObra> findAll() {
        return (List<ManoDeObra>) manoDeObraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ManoDeObra findById(Long id) {
        return manoDeObraDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ManoDeObra save(ManoDeObra equipo) {
        return manoDeObraDao.save(equipo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        manoDeObraDao.deleteById(id);
    }
}
