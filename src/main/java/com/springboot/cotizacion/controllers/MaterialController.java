package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.Material;
import com.springboot.cotizacion.models.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {
    @Autowired
    private IMaterialService iMaterialService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Material> listar(){
        return iMaterialService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public Material buscar(@PathVariable Long id){
        return iMaterialService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Material crear(@RequestBody Material material) {
        return iMaterialService.save(material);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Material editar(@RequestBody Material material, @PathVariable Long id) {
        Material materialDb = iMaterialService.findById(id);
        materialDb.setCategoria(material.getCategoria());
        materialDb.setCapacidad(material.getCapacidad());
        materialDb.setNombre(material.getNombre());
        materialDb.setPrecioCosto(material.getPrecioCosto());
        materialDb.setPrecioVenta(material.getPrecioVenta());
        return iMaterialService.save(materialDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iMaterialService.deleteById(id);
    }

    private boolean hasRole(String role) {

        SecurityContext context = SecurityContextHolder.getContext();

        if(context == null) {
            return false;
        }

        Authentication auth = context.getAuthentication();

        if(auth == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        return authorities.contains(new SimpleGrantedAuthority(role));

    }
}
