package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.Equipo;
import com.springboot.cotizacion.models.service.IEquipoService;
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
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService iEquipoService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Equipo> listar(){
        return iEquipoService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public Equipo buscar(@PathVariable Long id){
        return iEquipoService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo crear(@RequestBody Equipo equipo) {
        return iEquipoService.save(equipo);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo editar(@RequestBody Equipo equipo, @PathVariable Long id) {
        Equipo equipoDb = iEquipoService.findById(id);
        equipoDb.setCapacidad(equipo.getCapacidad());
        equipoDb.setCategoria(equipo.getCategoria());
        equipoDb.setMarca(equipo.getMarca());
        equipoDb.setModelo(equipo.getMarca());
        equipoDb.setNombre(equipo.getNombre());
        equipoDb.setPrecioCosto(equipo.getPrecioCosto());
        equipoDb.setPrecioVenta(equipo.getPrecioVenta());
        return iEquipoService.save(equipoDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iEquipoService.deleteById(id);
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
