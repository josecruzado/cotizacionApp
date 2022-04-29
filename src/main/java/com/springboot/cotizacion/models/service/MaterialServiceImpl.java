package com.springboot.cotizacion.models.service;

import com.springboot.cotizacion.models.dao.MaterialDao;
import com.springboot.cotizacion.models.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService{
    @Autowired
    private MaterialDao materialDao;

    @Override
    @Transactional(readOnly = true)
    public List<Material> findAll() {
        return (List<Material>) materialDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Material findById(Long id) {
        return materialDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Material save(Material material) {
        return materialDao.save(material);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        materialDao.deleteById(id);
    }
}
