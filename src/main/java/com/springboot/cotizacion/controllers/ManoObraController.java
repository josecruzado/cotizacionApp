package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.ManoDeObra;
import com.springboot.cotizacion.models.service.IManoDeObraService;
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
@RequestMapping("/api/manoObra")
public class ManoObraController {
    @Autowired
    private IManoDeObraService iManoDeObraService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<ManoDeObra> listar(){
        return iManoDeObraService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public ManoDeObra buscar(@PathVariable Long id){
        return iManoDeObraService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public ManoDeObra crear(@RequestBody ManoDeObra manoDeObra) {
        return iManoDeObraService.save(manoDeObra);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ManoDeObra editar(@RequestBody ManoDeObra manoDeObra, @PathVariable Long id) {
        ManoDeObra manoDeObraDb = iManoDeObraService.findById(id);
        manoDeObraDb.setDescripcion(manoDeObra.getDescripcion());
        manoDeObraDb.setPrecioCosto(manoDeObra.getPrecioCosto());
        manoDeObraDb.setPrecioVenta(manoDeObra.getPrecioCosto());
        return iManoDeObraService.save(manoDeObraDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iManoDeObraService.deleteById(id);
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
