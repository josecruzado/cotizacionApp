package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.LineaManoObra;
import com.springboot.cotizacion.models.service.ILineaManoObraService;
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
@RequestMapping("/api/lineaManoObra")
public class LineaManoObraController {
    @Autowired
    private ILineaManoObraService iLineaManoObraService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<LineaManoObra> listar(){
        return iLineaManoObraService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public LineaManoObra buscar(@PathVariable Long id){
        return iLineaManoObraService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaManoObra crear(@RequestBody LineaManoObra lineaManoObra) {
        return iLineaManoObraService.save(lineaManoObra);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaManoObra editar(@RequestBody LineaManoObra lineaManoObra, @PathVariable Long id) {
        LineaManoObra lineaManoObraDb = iLineaManoObraService.findById(id);
        lineaManoObraDb.setManoDeObra(lineaManoObra.getManoDeObra());
        lineaManoObraDb.setCantidad(lineaManoObra.getCantidad());
        lineaManoObraDb.setUtilidad(lineaManoObra.getUtilidad());
        lineaManoObraDb.setMargenUtilidad(lineaManoObra.getMargenUtilidad());
        return iLineaManoObraService.save(lineaManoObraDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iLineaManoObraService.deleteById(id);
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
