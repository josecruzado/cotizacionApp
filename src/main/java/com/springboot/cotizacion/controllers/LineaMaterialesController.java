package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.LineaMateriales;
import com.springboot.cotizacion.models.service.ILineaMaterialesService;
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
@RequestMapping("/api/lineaMateriales")
public class LineaMaterialesController {
    @Autowired
    private ILineaMaterialesService iLineaMaterialesService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<LineaMateriales> listar(){
        return iLineaMaterialesService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public LineaMateriales buscar(@PathVariable Long id){
        return iLineaMaterialesService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaMateriales crear(@RequestBody LineaMateriales lineaMateriales) {
        return iLineaMaterialesService.save(lineaMateriales);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaMateriales editar(@RequestBody LineaMateriales lineaMateriales, @PathVariable Long id) {
        LineaMateriales lineaMaterialesDb = iLineaMaterialesService.findById(id);
        lineaMaterialesDb.setMaterial(lineaMateriales.getMaterial());
        lineaMaterialesDb.setCantidad(lineaMateriales.getCantidad());
        lineaMaterialesDb.setUtilidad(lineaMateriales.getUtilidad());
        lineaMaterialesDb.setMargenUtilidad(lineaMateriales.getMargenUtilidad());
        return iLineaMaterialesService.save(lineaMaterialesDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iLineaMaterialesService.deleteById(id);
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
