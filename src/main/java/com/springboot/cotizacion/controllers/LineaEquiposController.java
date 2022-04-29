package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.LineaEquipos;
import com.springboot.cotizacion.models.service.ILineaEquiposService;
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
@RequestMapping("/api/lineaEquipos")
public class LineaEquiposController {
    @Autowired
    private ILineaEquiposService iLineaEquiposService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<LineaEquipos> listar(){
        return iLineaEquiposService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public LineaEquipos buscar(@PathVariable Long id){
        return iLineaEquiposService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaEquipos crear(@RequestBody LineaEquipos lineaEquipo) {
        return iLineaEquiposService.save(lineaEquipo);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaEquipos editar(@RequestBody LineaEquipos lineaEquipo, @PathVariable Long id) {
        LineaEquipos lineaEquiposDb = iLineaEquiposService.findById(id);
        lineaEquiposDb.setEquipo(lineaEquipo.getEquipo());
        lineaEquiposDb.setCantidad(lineaEquipo.getCantidad());
        lineaEquiposDb.setUtilidad(lineaEquipo.getUtilidad());
        lineaEquiposDb.setMargenUtilidad(lineaEquipo.getMargenUtilidad());
        return iLineaEquiposService.save(lineaEquiposDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iLineaEquiposService.deleteById(id);
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
