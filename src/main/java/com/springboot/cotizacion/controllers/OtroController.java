package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.Otro;
import com.springboot.cotizacion.models.service.IOtroService;
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
@RequestMapping("/api/otros")
public class OtroController {
    @Autowired
    private IOtroService iOtroService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Otro> listar(){
        return iOtroService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public Otro buscar(@PathVariable Long id){
        return iOtroService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Otro crear(@RequestBody Otro otro) {
        return iOtroService.save(otro);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Otro editar(@RequestBody Otro otro, @PathVariable Long id) {
        Otro otroDb = iOtroService.findById(id);
        otroDb.setDescripcion(otro.getDescripcion());
        otroDb.setPrecioCosto(otro.getPrecioCosto());
        otroDb.setPrecioVenta(otro.getPrecioVenta());
        return iOtroService.save(otroDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iOtroService.deleteById(id);
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
